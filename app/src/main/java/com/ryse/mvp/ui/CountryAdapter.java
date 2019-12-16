package com.ryse.mvp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ryse.mvp.R;
import com.ryse.mvp.model.Country;

import java.util.List;

class CountryAdapter extends BaseAdapter {

    private Context context;
    private List<Country> countryList;

    CountryAdapter(Context context, List<Country> countryList) {
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);

        Country country = (Country) getItem(position);
        viewHolder.bind(country);

        return convertView;
    }

    private class ViewHolder {

        private TextView tvCountryName, tvCountryRegion;

        ViewHolder(View view) {
            tvCountryName = view.findViewById(R.id.tv_countryName);
            tvCountryRegion = view.findViewById(R.id.tv_countryRegion);
        }

        void bind(Country country) {
            tvCountryName.setText(country.getCountryName());
            tvCountryRegion.setText(country.getCountryRegion());
        }
    }
}
