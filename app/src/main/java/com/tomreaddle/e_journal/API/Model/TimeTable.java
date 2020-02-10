package com.tomreaddle.e_journal.API.Model;

public class TimeTable {
    private int id;
    private String subject_name;
    private String teacher_fname;
    private String teacher_lname;
    private String theme;
    private String homework;
    private String rank;

    public TimeTable() {
    }

    public TimeTable(int id, String subject_name, String teacher_fname, String teacher_lname, String theme, String homework, String rank) {
        this.id = id;
        this.subject_name = subject_name;
        this.teacher_fname = teacher_fname;
        this.teacher_lname = teacher_lname;
        this.theme = theme;
        this.homework = homework;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public String getTeacher_fname() {
        return teacher_fname;
    }

    public String getTeacher_lname() {
        return teacher_lname;
    }

    public String getTheme() {
        return theme;
    }

    public String getHomework() {
        return homework;
    }

    public String getRank() {
        return rank;
    }
}
