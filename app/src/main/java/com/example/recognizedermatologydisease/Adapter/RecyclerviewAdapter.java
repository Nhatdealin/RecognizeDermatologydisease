package com.example.recognizedermatologydisease.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.recognizedermatologydisease.R;
import com.example.recognizedermatologydisease.Viewpageitem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {
    private List<Viewpageitem> mDataset;
    private Context mContext;
    Picasso picasso;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imvImage;

        public MyViewHolder(View view) {
            super(view);
            imvImage = view.findViewById(R.id.imv_viewpage_item);
        }
    }

    public RecyclerviewAdapter(Context context, List<Viewpageitem> myDataset) {
        this.mDataset = myDataset;
        this.mContext = context;
    }

    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerviewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.uploaded_image_item_viewpage, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerviewAdapter.MyViewHolder holder, int position) {
        Viewpageitem imageview = mDataset.get(position);
        Picasso.with(mContext).load(imageview.getImageUri()).fit().into(holder.imvImage);
        holder.imvImage.setImageURI(imageview.getImageUri());
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
