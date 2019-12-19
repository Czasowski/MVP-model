package com.example.test;

import android.content.Context;
import android.content.SharedPreferences;


public class MainModel implements MainContract.Model {

    private SharedPreferences pref;

    MainModel(Context context) {
        pref = context.getSharedPreferences("RANGER", 0);
    }

    @Override
    public void saveQ(String text) {
        SharedPreferences.Editor ed = pref.edit();
        ed.putString("RANGER", text);
        ed.apply();
    }

    @Override
    public String getQ() {
        return pref.getString("RANGER","0");
    }

}
