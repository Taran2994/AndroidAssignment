package com.example.myapplication;

import java.util.ArrayList;

public class SingletonClass {
    private static final SingletonClass sinObj = new SingletonClass();

    public static SingletonClass getInstance() {
        return sinObj;
    }

    private SingletonClass() {
    }

    ArrayList<Orders> orderList = new ArrayList<Orders>();


}
