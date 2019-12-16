package com.ryse.mvp.ui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ryse.mvp.base.BasePresenter;
import com.ryse.mvp.model.Country;
import com.ryse.mvp.utils.CountryApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryPresenter extends BasePresenter<CountryView> {

    private CountryApi service;

    @Override
    public void attachView(CountryView view) {
        super.attachView(view);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    void initialization() {
        if (isViewAttached()) getView().setService();
        getAsianCountryData();
    }

    void setService(CountryApi service) {
        this.service = service;
    }

    private Call<JsonArray> getAsianCountry() {
        return service.getAsianCountry();
    }

    private void getAsianCountryData() {
        getAsianCountry().enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.body() != null) {
                    ArrayList<Country> countryList = countryData(response.body());
                    if (isViewAttached()) getView().setAsianData(countryList);
                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {

            }
        });
    }

    private ArrayList<Country> countryData(JsonArray jsonArray) {
        ArrayList<Country> countryList = new ArrayList<>();

        for (int position = 0; position < jsonArray.size(); position++) {
            JsonObject jsonObject = jsonArray.get(position).getAsJsonObject();
            Country country = new Country();
            country.setCountryName(jsonObject.get("name").getAsString());
            country.setCountryRegion(jsonObject.get("region").getAsString());
            countryList.add(country);
        }

        return countryList;
    }
}
