package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter {
    private LayoutInflater layoutInflater;
    private int layoutResource;
    private ArrayList<Orders> orderList;
    public OrderAdapter(@NonNull Context context, int resource, ArrayList<Orders> olist) {
        super(context, resource,olist);
        this.layoutInflater = LayoutInflater.from(context);
        this.layoutResource = resource;
        this.orderList=olist;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null)
            v = layoutInflater.inflate(layoutResource, parent, false);
        TextView orderVal = v.findViewById(R.id.orderValue);
        TextView priceVal = v.findViewById(R.id.priceValue);

        orderVal.setText(orderList.get(position).getName());
        priceVal.setText(Double.toString(orderList.get(position).getTotal()));

        return v;


    }
}
