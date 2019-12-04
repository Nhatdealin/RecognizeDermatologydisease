package com.example.recognizedermatologydisease;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recognizedermatologydisease.Adapter.RecyclerviewAdapter;

import java.util.ArrayList;

public class UploadedImageActivity extends AppCompatActivity {
    ArrayList<Uri> mListUri;
    RecyclerView  mViewpageRecyclerView;
    ArrayList<Viewpageitem> pageviewitemlist;
    LinearLayoutManager mLayoutManagerPageView;
    RecyclerviewAdapter mViewPageAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_recyclerview);
        pageviewitemlist = new ArrayList<>();
        mListUri = new ArrayList<>();
        Intent intent = this.getIntent();
        mListUri =  (ArrayList<Uri>) intent.getSerializableExtra("listuri");
        mLayoutManagerPageView = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mViewpageRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_uploaded_image);
        ViewCompat.setNestedScrollingEnabled(mViewpageRecyclerView, false);
        mViewpageRecyclerView.setLayoutManager(mLayoutManagerPageView);
        for (int i=0; i< mListUri.size();i++)
        {
            pageviewitemlist.add(new Viewpageitem(mListUri.get(i)));
        }
        mViewPageAdapter = new RecyclerviewAdapter(this, pageviewitemlist);
        mViewpageRecyclerView.setAdapter(mViewPageAdapter);

    }
}
