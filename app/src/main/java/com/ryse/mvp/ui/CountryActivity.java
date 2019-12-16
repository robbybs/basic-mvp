package com.ryse.mvp.ui;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.ryse.mvp.R;
import com.ryse.mvp.model.Country;
import com.ryse.mvp.utils.CountryApi;
import com.ryse.mvp.utils.CountryApiRequest;

import java.util.List;

public class CountryActivity extends AppCompatActivity implements CountryView {

    CountryPresenter presenter;
    ListView countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializePresenter();
        initializeLayout();
    }

    @Override
    public void initializePresenter() {
        presenter = new CountryPresenter();
        presenter.attachView(this);
        presenter.initialization();
    }

    @Override
    public void initializeLayout() {
        countryList = findViewById(R.id.lv_countryList);
    }

    @Override
    public void setService() {
        CountryApi service = CountryApiRequest.getAPI().create(CountryApi.class);
        presenter.setService(service);
    }

    @Override
    public void setAsianData(List<Country> data) {
        CountryAdapter adapter = new CountryAdapter(this, data);
        countryList.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}
