package com.tomreaddle.e_journal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.tomreaddle.e_journal.API.Client.RetrofitClient;
import com.tomreaddle.e_journal.API.Model.FeedbackData;
import com.tomreaddle.e_journal.API.Model.FeedbackResponse;
import com.tomreaddle.e_journal.API.Model.TokenData;
import com.tomreaddle.e_journal.API.ResService.ApiService;
import com.tomreaddle.e_journal.Services.MySharedPreferencesSettings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Feedback extends AppCompatActivity {

    EditText name , number , content;
    CheckBox checkBox;
    Button send , back2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.feedback);

        name = findViewById(R.id.name_feedback);
        number = findViewById(R.id.phone_feedback);
        content = findViewById(R.id.content_feedback);
        checkBox = findViewById(R.id.checkbox_feedback);
        send = findViewById(R.id.feedback_send_button);
        back2 = findViewById(R.id.back_feedback_2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    number.setEnabled(true);
                    number.setBackgroundResource(R.drawable.feedback_back_active);
                    number.setTextColor(getResources().getColor(R.color.black));
                } else {
                    number.setEnabled(false);
                    number.setBackgroundResource(R.drawable.feedback_back_disable);
                    number.setTextColor(getResources().getColor(R.color.feedback_light));
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            postFeedback();
            }
        });
    }

    public void postFeedback() {
        FeedbackData feedbackData = new FeedbackData(name.getText().toString() , number.getText().toString() , content.getText().toString());
        ApiService api = RetrofitClient.getApiService();
        Call<FeedbackResponse> call = api.feedback(feedbackData);
        call.enqueue(new Callback<FeedbackResponse>() {
            @Override
            public void onResponse(Call<FeedbackResponse> call, Response<FeedbackResponse> response) {
                if(response.isSuccessful()){
                    Toast.makeText(Feedback.this, R.string.sent_feedback, Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(Feedback.this , MainActivity.class));
                } else {
                    Toast.makeText(Feedback.this, R.string.upload_error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FeedbackResponse> call, Throwable t) {
                Toast.makeText(Feedback.this, R.string.connecting_error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
