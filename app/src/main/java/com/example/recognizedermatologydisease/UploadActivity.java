package com.example.recognizedermatologydisease;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.content.FileProvider;
import android.util.Base64;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class UploadActivity extends AppCompatActivity implements View.OnClickListener{
    private final int PICK_IMAGE_REQUEST = 71;
    private static final int SELECT_PICTURE = 279;
    private final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 195;
    private Uri mImageCaptureUri;
    private ArrayList<Uri> mListImageCaptureUri;
    private ArrayList<File> mListFile;
    private String myImagePath, myImagePathCrop;
    File finalFile;
    private String Document_img1="";
    int maxCrop = 0;
    int countCrop = 0;
    private Button btnChoseImage, btnCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_file);
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        mListFile = new ArrayList<File>();
        mListImageCaptureUri = new ArrayList<Uri>();
        btnChoseImage = findViewById(R.id.btn_upload_file);
        btnCamera = findViewById(R.id.btn_take_photo);
        addListener();
    }

    protected void addListener() {
        btnChoseImage.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
    }


    public void onClickTakeAPhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = new File(getFilesDir(), "temp.jpg");
        Uri data = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", file);
        //this.grantUriPermission(this.getPackageName(), data, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        mImageCaptureUri = data;

        myImagePath = file.getPath();
        takePictureIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        //takePictureIntent.putExtra("return-data", true);
        //takePictureIntent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION, true);
        startActivityForResult(takePictureIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
    }

    private void onClickChooseFromGallery() {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/DATA");
        if (!file.exists()) {
            file.mkdirs();
        }
        File f = new File(file.getPath() + "/" + SystemClock.currentThreadTimeMillis() + ".jpg");
        mImageCaptureUri = Uri.fromFile(f);
        myImagePath = f.getPath();

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null )
        {
            Uri filePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        //super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE:
                    try {
                        Bundle extras = null;
                        if (data != null) {
                            extras = data.getExtras();
                        }
                        mListFile = new ArrayList<File>();
                        mListImageCaptureUri = new ArrayList<Uri>();
                        if (data != null && extras != null && extras.get("data") != null) {
                            File f = new File(myImagePath);
                            Bitmap bitMap = (Bitmap) extras.get("data");
                            ByteArrayOutputStream bos = new ByteArrayOutputStream();
                            bitMap.compress(Bitmap.CompressFormat.PNG, 0, bos);
                            byte[] bitmapdata = bos.toByteArray();
                            FileOutputStream fos;
                            try {
                                fos = new FileOutputStream(f);
                                try {
                                    fos.write(bitmapdata);
                                    mImageCaptureUri = Uri.fromFile(f);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Take with Uri
                        }
                    } catch (NullPointerException ex) {
                        ex.printStackTrace();
                    }
                    maxCrop = 1;
                    countCrop = 0;
                    doCrop();
                    break;
                case SELECT_PICTURE:
                    countCrop = 0;
                    mListFile = new ArrayList<File>();
                    mListImageCaptureUri = new ArrayList<Uri>();
                    if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2)
                            && (null == data.getData()))
                    {
                        ClipData clipdata = data.getClipData();
                        maxCrop = clipdata.getItemCount();
                        for (int i=0; i<clipdata.getItemCount();i++)
                        {
                            mImageCaptureUri = clipdata.getItemAt(i).getUri();
                            File finalFile1 = new File(getRealPathFromURI(mImageCaptureUri));
                            String[] spl = finalFile1.getPath().split("/");
                            String name1 = spl[spl.length - 1];
                            String[] end = name1.split("\\.");
                            String endName = end[end.length - 1];
                            String newName = finalFile1.getPath().substring(0, finalFile1.getPath().length() - 1 - name1.length())
                                    + "/" + SystemClock.currentThreadTimeMillis() + "." + endName;
                            try {
                                copy(finalFile1, new File(newName));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            myImagePath = newName;
                            doCrop();
                            }
                        }

                    break;
                case Crop.REQUEST_CROP:
                    Uri tempUri = Crop.getOutput(data);
//                    mImgAvatar.setImageURI(tempUri);
                    File finalFile = new File(tempUri.getPath());
                    String[] spl1 = finalFile.getPath().split("/");
                    String name11 = spl1[spl1.length - 1];
                    String[] end1 = name11.split("\\.");
                    String endName1 = end1[end1.length - 1];
                    String newName1 = finalFile.getPath().substring(0,
                            finalFile.getPath().length() - 1 - name11.length()) + "/"
                            + SystemClock.currentThreadTimeMillis() + "." + endName1;

                    try {
                        copy(finalFile, new File(newName1));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    myImagePathCrop = newName1;
                    if (myImagePathCrop != null) {
                        File f = new File(myImagePathCrop);
                        if (f.exists()) {
                            finalFile = f;
                        }
                        mListImageCaptureUri.add(Uri.fromFile(f));
                        mListFile.add(f);

                    }
                    countCrop ++;
                    if (countCrop >= maxCrop){
                        Intent intent2 = new Intent(UploadActivity.this, UploadedImageActivity.class);
                        intent2.putExtra("listuri",mListImageCaptureUri);
                        startActivity(intent2);
                    }


                    break;
            }

        }
    }

    private void doCrop() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        String timeStamp = dateFormat.format(new Date());
        String imageFileName = "picture_crop" + timeStamp + ".jpg";
        Uri destination = Uri.fromFile(new File(this.getCacheDir(), imageFileName));
        Crop.of(mImageCaptureUri, destination).asSquare().start(this);
    }
    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = this.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }

    void copy(File source, File target) throws IOException {

        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int len;

        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    private void selectImage() {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(UploadActivity.this);
        builder.setTitle("Add Photo!");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo"))
                {
                    onClickTakeAPhoto();
                }
                else if (options[item].equals("Choose from Gallery"))
                {
                    onClickChooseFromGallery();
                }
                else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 1) {
//                File f = new File(Environment.getExternalStorageDirectory().toString());
//                for (File temp : f.listFiles()) {
//                    if (temp.getName().equals("temp.jpg")) {
//                        f = temp;
//                        break;
//                    }
//                }
//                try {
//                    Bitmap bitmap;
//                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
//                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(), bitmapOptions);
//                    bitmap=getResizedBitmap(bitmap, 400);
//                    imvReview.setImageBitmap(bitmap);
//                    BitMapToString(bitmap);
//                    String path = android.os.Environment
//                            .getExternalStorageDirectory()
//                            + File.separator
//                            + "Phoenix" + File.separator + "default";
//                    f.delete();
//                    OutputStream outFile = null;
//                    File file = new File(path, String.valueOf(System.currentTimeMillis()) + ".jpg");
//                    try {
//                        outFile = new FileOutputStream(file);
//                        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, outFile);
//                        outFile.flush();
//                        outFile.close();
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            } else if (requestCode == 2) {
//                Uri selectedImage = data.getData();
//                String[] filePath = { MediaStore.Images.Media.DATA };
//                Cursor c = getContentResolver().query(selectedImage,filePath, null, null, null);
//                c.moveToFirst();
//                int columnIndex = c.getColumnIndex(filePath[0]);
//                String picturePath = c.getString(columnIndex);
//                c.close();
//                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
//                thumbnail=getResizedBitmap(thumbnail, 400);
//                Log.w("path of imagegallery...", picturePath+"");
//                imvReview.setImageBitmap(thumbnail);
//                BitMapToString(thumbnail);
//            }
//        }
//    }
//    public String BitMapToString(Bitmap userImage1) {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        userImage1.compress(Bitmap.CompressFormat.PNG, 60, baos);
//        byte[] b = baos.toByteArray();
//        Document_img1 = Base64.encodeToString(b, Base64.DEFAULT);
//        return Document_img1;
//    }
//
//    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
//        int width = image.getWidth();
//        int height = image.getHeight();
//
//        float bitmapRatio = (float)width / (float) height;
//        if (bitmapRatio > 1) {
//            width = maxSize;
//            height = (int) (width / bitmapRatio);
//        } else {
//            height = maxSize;
//            width = (int) (height * bitmapRatio);
//        }
//        return Bitmap.createScaledBitmap(image, width, height, true);
//    }
//
//    private void SendDetail() {
//    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_upload_file:
                selectImage();
                break;
            case R.id.btn_take_photo:
                onClickTakeAPhoto();
                break;
        }
    }

}
