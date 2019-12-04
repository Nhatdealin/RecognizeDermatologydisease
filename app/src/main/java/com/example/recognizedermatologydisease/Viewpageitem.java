package com.example.recognizedermatologydisease;

import android.net.Uri;

public class Viewpageitem {
    private Uri imageUri;

    public Viewpageitem(Uri uri) {
        this.imageUri=uri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
