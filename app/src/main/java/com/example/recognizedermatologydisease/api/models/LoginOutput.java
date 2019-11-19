package com.example.recognizedermatologydisease.api.models;

import com.example.recognizedermatologydisease.models.DataLogin;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Admin on 4/13/2017.
 */

public class LoginOutput extends BaseOutput {

    @SerializedName("message")
    public String message;
    @SerializedName("data")
    public DataLogin data ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataLogin getData() {
        return data;
    }

    public void setData(DataLogin data) {
        this.data = data;
    }
}
