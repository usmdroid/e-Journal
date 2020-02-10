package com.tomreaddle.e_journal.Services;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferencesData {

    SharedPreferences sPref;
    public MySharedPreferencesData(Context context){
        sPref = context.getSharedPreferences("data" , Context.MODE_PRIVATE);
    }

    public void setNameProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("name_profile" , token);
        ed.commit();
    }

    public String getNameProfile(){
        return sPref.getString("name_profile" , "null");
    }

    public void setSchoolProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("school_profile" , token);
        ed.commit();
    }

    public String getSchoolProfile(){
        return sPref.getString("school_profile" , "null");
    }

    public void setClassProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("class_profile" , token);
        ed.commit();
    }

    public String getClassProfile(){
        return sPref.getString("class_profile" , "null");
    }

    public void setAdressProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("adress_profile" , token);
        ed.commit();
    }

    public String getAdressProfile(){
        return sPref.getString("adress_profile" , "null");
    }

    public void setAdressFullProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("adress_full_profile" , token);
        ed.commit();
    }

    public String getAdressFullProfile(){
        return sPref.getString("adress_full_profile" , "null");
    }

    public void setAdressMailProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("adress_mail_profile" , token);
        ed.commit();
    }

    public String getAdressMailProfile(){
        return sPref.getString("adress_mail_profile" , "null");
    }

    public void setTeacherNameProfile(String name){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("teacher_name__profile" , name);
        ed.commit();
    }

    public String getTeacherNameProfile(){
        return sPref.getString("teacher_fname_profile" , "null");
    }

    public void setPhoneProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("phone" , token);
        ed.commit();
    }

    public String getPhoneProfile(){
        return sPref.getString("phone" , "null");
    }

    public void setDirectorProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("director" , token);
        ed.commit();
    }

    public String getDirectorProfile(){
        return sPref.getString("director" , "null");
    }

    public void setImageURLProfile(String token){
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("image" , token);
        ed.commit();
    }

    public String getImageURLProfile(){
        return sPref.getString("image" , "null");
    }

}
