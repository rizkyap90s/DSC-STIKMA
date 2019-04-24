package com.example.firstapi.model;

import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("original_title")
    private String mtitle;

    @SerializedName("vote_average")
    private Double mrating;

    @SerializedName("poster_path")
    private String mposter;

    @SerializedName("backdrop_path")
    private String mbackdrop;

    @SerializedName("overview")
    private String moverview;

    @SerializedName("release_date")
    private String mdate;

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public Double getMrating() {
        return mrating;
    }

    public void setMrating(Double mrating) {
        this.mrating = mrating;
    }

    public String getMposter() {
        return "https://image.tmdb.org/t/p/w500"+ mposter;
    }

    public void setMposter(String mposter) {
        this.mposter = mposter;
    }

    public String getMbackdrop() {
        return "https://image.tmdb.org/t/p/w500"+mbackdrop;
    }

    public void setMbackdrop(String mbackdrop) {
        this.mbackdrop = mbackdrop;
    }

    public String getMoverview() {
        return moverview;
    }

    public void setMoverview(String moverview) {
        this.moverview = moverview;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public Movies(String mtitle, Double mrating, String mposter, String mbackdrop, String moverview, String mdate) {
        this.mtitle = mtitle;
        this.mrating = mrating;
        this.mposter = mposter;
        this.mbackdrop = mbackdrop;
        this.moverview = moverview;
        this.mdate = mdate;
    }

}
