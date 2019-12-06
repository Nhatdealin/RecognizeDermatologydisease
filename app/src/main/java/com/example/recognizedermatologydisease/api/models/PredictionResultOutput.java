package com.example.recognizedermatologydisease.api.models;

import com.example.recognizedermatologydisease.models.PredictionResult;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


/**
 * Created by Admin on 4/13/2017.
 */

public class PredictionResultOutput extends BaseOutput {
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private ArrayList<PredictionResult> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<PredictionResult> getData() {
        return data;
    }

    public void setData(ArrayList<PredictionResult> data) {
        this.data = data;
    }
}
