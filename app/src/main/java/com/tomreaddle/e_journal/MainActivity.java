package com.tomreaddle.e_journal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tomreaddle.e_journal.Fragment.mainProfiles;
import com.tomreaddle.e_journal.Fragment.newsFrag;
import com.tomreaddle.e_journal.Fragment.rankTasksFrag;
import com.tomreaddle.e_journal.Services.MySharedPreferences;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottom;
    Toolbar toolbar;
    FrameLayout fragment;
    RelativeLayout drawer , main;
    private long backpressedtime;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setLocale();
        setContentView(R.layout.drawer_nav);

        setRankTasksFrag();
        toolbar = (androidx.appcompat.widget.Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar , R.string.open_drawer , R.string.close_drawer);
            drawerLayout.setDrawerListener(toggle);
            toggle.syncState();

        bottom = findViewById(R.id.BottomBar);
        fragment = findViewById(R.id.fragment);
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.main:
                        toolbar.setTitle(item.getTitle());
                        setRankTasksFrag();
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.info:
                        toolbar.setTitle(item.getTitle());
                        setNewsFrag();
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.event:
                        toolbar.setTitle(item.getTitle());
                        setPupilsPage();
                        Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }

    public void setPupilsPage(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mainProfiles mainFrag = new mainProfiles();
        fragmentTransaction.replace(R.id.fragment , mainFrag);
        fragmentTransaction.commit();
    }

    public void setRankTasksFrag(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        rankTasksFrag rankTasksFrag = new rankTasksFrag();
        fragmentTransaction.replace(R.id.fragment , rankTasksFrag);
        fragmentTransaction.commit();
    }

    public void setNewsFrag(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        newsFrag newsFrag = new newsFrag();
        fragmentTransaction.replace(R.id.fragment , newsFrag);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if(backpressedtime +2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        } else {
            Toast.makeText(this, "Chiqib ketish uchun yana bosing", Toast.LENGTH_SHORT).show();
        }
            backpressedtime = System.currentTimeMillis();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_bar , menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id){
            case R.id.attendance_nav_bar:
                Toast.makeText(this, "Attendance", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rank_nav_bar:
                Toast.makeText(this, "Rank", Toast.LENGTH_SHORT).show();
                break;
            case R.id.task_nav_bar:
                Toast.makeText(this, "Task", Toast.LENGTH_SHORT).show();
                break;
            case R.id.teacher_nav_bar:
                Toast.makeText(this, "Teacher", Toast.LENGTH_SHORT).show();
                break;
            case R.id.notice_nav_bar:
                Toast.makeText(this, "Notice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings_nav_bar:
                startActivity(new Intent(MainActivity.this, Settings.class));
                finish();
                break;
            case R.id.feedback_nav_bar:
                startActivity(new Intent(MainActivity.this, Feedback.class));
                break;
            case R.id.faq_nav_bar:
                startActivity(new Intent(MainActivity.this, FAQ.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setLocale(){

        MySharedPreferences sPref = new MySharedPreferences(this);
        String locale = sPref.getLang();
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(locale.toLowerCase()));
        res.updateConfiguration(conf , dm);
        Toast.makeText(this, locale, Toast.LENGTH_SHORT).show();
    }

}
