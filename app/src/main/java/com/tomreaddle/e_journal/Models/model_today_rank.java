package com.tomreaddle.e_journal.Models;

import java.util.Date;

public class model_today_rank {
    private String subject;
    private String teacher;
    private String theme;
    private String homework;
    private String rank;

    public model_today_rank() {
    }

    public model_today_rank(String subject, String teacher, String theme, String homework, String rank) {
        this.subject = subject;
        this.teacher = teacher;
        this.theme = theme;
        this.homework = homework;
        this.rank = rank;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
