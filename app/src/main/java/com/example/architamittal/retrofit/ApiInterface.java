package com.example.architamittal.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/facts/random")

    Call<List<Facts>> getAllFacts(@Query("animal") String animal,@Query("amount") int amount);
}
