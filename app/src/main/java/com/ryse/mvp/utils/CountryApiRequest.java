package com.ryse.mvp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryApiRequest {
    private static final String BASE_URL = "https://restcountries.eu/rest/v2/region/";

    public static Retrofit getAPI() {
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
