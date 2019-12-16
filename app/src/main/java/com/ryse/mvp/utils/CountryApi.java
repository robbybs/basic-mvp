package com.ryse.mvp.utils;

import com.google.gson.JsonArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryApi {

    @GET("asia")
    Call<JsonArray> getAsianCountry();
}
