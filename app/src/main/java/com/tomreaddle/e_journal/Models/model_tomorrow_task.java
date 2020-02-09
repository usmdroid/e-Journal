package com.tomreaddle.e_journal.Models;

public class model_tomorrow_task {
    private String subject;
    private String task;

    public model_tomorrow_task(String subject, String task) {
        this.subject = subject;
        this.task = task;
    }

    public String getSubject() {
        return subject;
    }

    public String getTask() {
        return task;
    }
}
