package com.tomreaddle.e_journal.Models;

public class model_news_item {

        private int image;
        private String title;
        private String excerpt;
        private String date;

    public model_news_item(int image, String title, String excerpt, String date) {
        this.image = image;
        this.title = title;
        this.excerpt = excerpt;
        this.date = date;
    }
}
