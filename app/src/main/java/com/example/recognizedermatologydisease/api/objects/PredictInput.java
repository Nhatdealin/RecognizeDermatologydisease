package com.example.recognizedermatologydisease.api.objects;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by dcmen on 9/30/2016.
 */
public class PredictInput {
    @SerializedName("file")
    public ArrayList<File> files;


    public PredictInput(ArrayList<File> files) {
        this.files = files;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }
}
