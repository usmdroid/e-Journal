package com.tomreaddle.e_journal.API.Model;

public class TeacherData {

    private String id;
    private String f_name;
    private String l_name;
    private String teacher_id;
    private String subject_name;
    private String phone;

    public TeacherData(String id, String f_name, String l_name, String teacher_id, String subject_name, String phone) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.teacher_id = teacher_id;
        this.subject_name = subject_name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getF_name() {
        return f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getPhone() {
        return phone;
    }
}
