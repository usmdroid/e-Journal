package com.tomreaddle.e_journal.API.Model;

import com.google.gson.annotations.SerializedName;

public class InfoData {

    private String id;
    private String first_name;
    private String last_name;
    private String teacher_id;
    private String class_name;
    private String teacher_fname;
    private String teacher_lname;
    private String subject_name;
    private String school_name;
    private String adress;
    private String adress_full;
    private String adress_mail;
    private String phone;
    private String director;
    private String image;

    public InfoData(String id, String first_name, String last_name, String teacher_id, String class_name, String teacher_fname, String teacher_lname, String subject_name, String school_name, String adress, String adress_full, String adress_mail, String phone, String director, String image) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.teacher_id = teacher_id;
        this.class_name = class_name;
        this.teacher_fname = teacher_fname;
        this.teacher_lname = teacher_lname;
        this.subject_name = subject_name;
        this.school_name = school_name;
        this.adress = adress;
        this.adress_full = adress_full;
        this.adress_mail = adress_mail;
        this.phone = phone;
        this.director = director;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public String getTeacher_fname() {
        return teacher_fname;
    }

    public String getTeacher_lname() {
        return teacher_lname;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getSchool_name() {
        return school_name;
    }

    public String getAdress() {
        return adress;
    }

    public String getAdress_full() {
        return adress_full;
    }

    public String getAdress_mail() {
        return adress_mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getDirector() {
        return director;
    }

    public String getImage() {
        return image;
    }
}
