package com.example.recognizedermatologydisease.api.models;

import com.example.recognizedermatologydisease.models.DataProjects;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Admin on 4/13/2017.
 */

public class ProjectsOutput extends BaseOutput {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataProjects data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataProjects getData() {
        return data;
    }

    public void setData(DataProjects data) {
        this.data = data;
    }

}
