package com.tomreaddle.e_journal;

import android.annotation.SuppressLint;
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

public class Feedback extends AppCompatActivity {

    EditText name , number , content;
    CheckBox checkBox;
    Button send , back2;
    ImageView back1;

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
        back1 = findViewById(R.id.back_feedback_1);
        back2 = findViewById(R.id.back_feedback_2);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

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
                Toast.makeText(Feedback.this, name.getText() + "\n"
                        + number.getText() + "\n"
                        + content.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
