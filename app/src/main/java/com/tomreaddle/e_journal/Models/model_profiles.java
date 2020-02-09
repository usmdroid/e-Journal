package com.tomreaddle.e_journal.Models;

public class model_profiles {

    String picture_URL;
    String name;
    String school;
    String class_num;

    public model_profiles() {
    }

    public model_profiles(String picture_URL, String name, String school, String class_num) {
        this.picture_URL = picture_URL;
        this.name = name;
        this.school = school;
        this.class_num = class_num;
    }

    public String getPicture_URL() {
        return picture_URL;
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getClass_num() {
        return class_num;
    }
}
