package com.tomreaddle.e_journal.API.Model;

import com.google.gson.annotations.SerializedName;

public class InfoData {

    int id;
    String first_name;
    String last_name;
    String teacher_id;
    String teacher_fname;
    String teacher_lname;
    String subject_name;
    String class_name;

    @SerializedName("id")
    public int getId() {
        return id;
    }

    @SerializedName("first_name")
    public String getEmail() {
        return first_name;
    }

    @SerializedName("last_name")
    public String getPassword() {
        return last_name;
    }

    @SerializedName("teacher_id")
    public String getTeacher_id() {
        return teacher_id;
    }

    @SerializedName("teacher_fname")
    public String getTeacher_fname() {
        return teacher_fname;
    }

    @SerializedName("teacher_lname")
    public String getTeacher_lname() {
        return teacher_lname;
    }

    @SerializedName("subject_name")
    public String getSubject_name() {
        return subject_name;
    }

    @SerializedName("class_name")
    public String getClass_name() {
        return class_name;
    }
}
