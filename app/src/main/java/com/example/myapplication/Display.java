package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Display extends AppCompatActivity {

    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        SingletonClass obj=SingletonClass.getInstance();


        ListView listView=findViewById(R.id.listv);


        orderAdapter = new OrderAdapter(this, R.layout.order_adapter_layout, obj.orderList);
        listView.setAdapter(orderAdapter);

    }
}
