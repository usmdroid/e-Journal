package com.tomreaddle.e_journal.Models;

public class model_profiles {

    int id;
    String picture_URL;
    String name;
    String school;
    String class_num;
    String token;

    public model_profiles() {
    }

    public model_profiles(String picture_URL, String name, String school, String class_num ) {
        this.picture_URL = picture_URL;
        this.name = name;
        this.school = school;
        this.class_num = class_num;
    }

    public model_profiles(int id, String picture_URL, String name, String school, String class_num, String token) {
        this.id = id;
        this.picture_URL = picture_URL;
        this.name = name;
        this.school = school;
        this.class_num = class_num;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture_URL() {
        return picture_URL;
    }

    public void setPicture_URL(String picture_URL) {
        this.picture_URL = picture_URL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
