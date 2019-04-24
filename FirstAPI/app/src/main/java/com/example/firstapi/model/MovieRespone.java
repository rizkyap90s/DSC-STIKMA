package com.example.firstapi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRespone {

    public List<Movies> getMresult() {
        return mresult;
    }

    public void setMresult(List<Movies> mresult) {
        this.mresult = mresult;
    }

    @SerializedName("results")
    private List<Movies> mresult;
}
