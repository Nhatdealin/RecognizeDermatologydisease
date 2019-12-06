package com.example.recognizedermatologydisease.models;

import com.google.gson.annotations.SerializedName;

public class PredictionResult {
    @SerializedName("id")
    private Long id;
    @SerializedName("class")
    private String classes;
    @SerializedName("percent")
    private float percent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
