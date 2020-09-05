package com.example.corona_final_withapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterFace {

    @GET("countries")
    Call<List<ObjectDataClass>> GetData();
}
