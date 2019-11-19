package com.example.recognizedermatologydisease.api.models;

import com.example.recognizedermatologydisease.models.DataProfile;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Admin on 4/13/2017.
 */

public class ProfileOutput extends BaseOutput {

    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public DataProfile data ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataProfile getData() {
        return data;
    }

    public void setData(DataProfile data) {
        this.data = data;
    }
}
