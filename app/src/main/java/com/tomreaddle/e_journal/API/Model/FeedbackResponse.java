package com.tomreaddle.e_journal.API.Model;

import com.google.gson.annotations.SerializedName;

public class FeedbackResponse {

    @SerializedName("submitted")
    private String submitted;

    public FeedbackResponse(String submitted) {
        this.submitted = submitted;
    }
}
