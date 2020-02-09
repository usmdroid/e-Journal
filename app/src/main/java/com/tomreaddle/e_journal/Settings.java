package com.tomreaddle.e_journal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import java.util.Locale;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.tomreaddle.e_journal.Services.MySharedPreferences;

public class Settings extends AppCompatActivity {

    TextView about_theme , about_notify , language_title , app_lang;
    Switch theme , notify;
    RelativeLayout language;
    AlertDialog dialog;
    AlertDialog.Builder builder;
    String[] lang = {"O'zbek" , "Русский" };
    MySharedPreferences mySharedPreferences ;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    {
        mySharedPreferences = new MySharedPreferences(this);
        setLocale(mySharedPreferences.getLang());
    }

        setContentView(R.layout.settings);

        about_theme = findViewById(R.id.theme_sub_settings);
        about_notify = findViewById(R.id.notify_sub_settings);
        language = findViewById(R.id.language);
        app_lang = findViewById(R.id.language_selected_settings);
        theme = findViewById(R.id.theme_settings);
        notify = findViewById(R.id.notify_settings);
        language_title = findViewById(R.id.language_selected_settings);

        language.setOnClickListener(new View.OnClickListener() {

            String lang_select;

            @Override
            public void onClick(View v) {
                builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Tilni o'zgartirish");
                builder.setSingleChoiceItems(lang, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                lang_select = "uz";
                                Toast.makeText(Settings.this, lang_select, Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                lang_select = "ru";
                                Toast.makeText(Settings.this, lang_select, Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mySharedPreferences.setLang(lang_select);
                        String current_lang = mySharedPreferences.getLang();
                        setLocale(current_lang);
                        Toast.makeText(Settings.this, mySharedPreferences.getLang()+"Lang", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(Settings.this , Settings.class));
                    }
                });
                builder.setNegativeButton("Yo'q", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog = builder.create();
                dialog.show();

            }
        });


    }

    public void setLocale(String locale){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(locale.toLowerCase()));
        res.updateConfiguration(conf , dm);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Settings.this , MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }

}
