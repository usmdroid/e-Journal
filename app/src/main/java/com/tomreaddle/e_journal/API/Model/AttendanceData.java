package com.tomreaddle.e_journal.API.Model;

public class AttendanceData {

    private String id;
    private String subject;
    private String date;
    private String time;

    public AttendanceData(String id, String subject, String date, String time) {
        this.id = id;
        this.subject = subject;
        this.date = date;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
