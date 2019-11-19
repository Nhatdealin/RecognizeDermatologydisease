package com.example.recognizedermatologydisease.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 4/13/2017.
 */

public class StringOutput extends BaseOutput {
    @SerializedName("result")
    public String result;
}
