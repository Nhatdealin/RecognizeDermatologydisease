package com.example.recognizedermatologydisease.tasks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.recognizedermatologydisease.api.ApiListener;
import com.example.recognizedermatologydisease.api.models.PredictionResultOutput;
import com.example.recognizedermatologydisease.api.objects.PredictInput;

import java.io.File;
import java.util.ArrayList;

public class PredictTask extends BaseTask<PredictionResultOutput>{
    ArrayList<File> uploadFiles;
    public PredictTask(Context context, ArrayList<File> updateFiles, @Nullable ApiListener<PredictionResultOutput> listener) {
        super(context, listener);
        this.uploadFiles = updateFiles;
    }

    @Override
    protected PredictionResultOutput callApiMethod() throws Exception {
        return mApi.predict(new PredictInput(uploadFiles));
    }
}
