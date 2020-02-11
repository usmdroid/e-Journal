package com.tomreaddle.e_journal.Models;

public class model_news_item {

    private String id;
    private String title;
    private String exerpt;
    private String time;
    private String date;
    private String image;

    public model_news_item(String id, String title, String exerpt, String time, String date, String image) {
        this.id = id;
        this.title = title;
        this.exerpt = exerpt;
        this.time = time;
        this.date = date;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getExerpt() {
        return exerpt;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }
}
