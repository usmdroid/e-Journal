package com.tomreaddle.e_journal.Services;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferencesSettings {

    SharedPreferences sPref;

    public MySharedPreferencesSettings(Context context) {
        sPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setLang(String lang) {
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("lang", lang);
        ed.commit();
    }

    public String getLang() {
        return sPref.getString("lang", "null");
    }

    public void setToken(String token) {
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("token", token);
        ed.commit();
    }

    public String getToken() {
        return sPref.getString("token", "");
    }
}
