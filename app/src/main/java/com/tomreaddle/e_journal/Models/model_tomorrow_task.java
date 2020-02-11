package com.tomreaddle.e_journal.Models;

public class model_tomorrow_task {

    private int id;
    private String subject;
    private String task;
    private String time;

    public model_tomorrow_task(int id, String subject, String task, String time) {
        this.id = id;
        this.subject = subject;
        this.task = task;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getSubject() {
        return subject;
    }

    public String getTime() {
        return time;
    }
}
