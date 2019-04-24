package com.example.firstapi.api;

import com.example.firstapi.model.MovieRespone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {

    @GET("movie/now_playing")
    Call<MovieRespone> getNowPlayingMovie(@Query("api_key")String apikey);

}
