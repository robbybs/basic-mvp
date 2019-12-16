package com.ryse.mvp.ui;

import com.ryse.mvp.base.View;
import com.ryse.mvp.model.Country;

import java.util.List;

interface CountryView extends View {

    void setService();

    void setAsianData(List<Country> data);
}
