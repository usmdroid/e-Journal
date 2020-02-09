package com.tomreaddle.e_journal;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

public class screen_splash extends AppCompatActivity {

    private RelativeLayout constraintLayout;
    private AnimationDrawable animationDrawable;
    private static int SPLASH_TIME_OUT = 4000;
    ShimmerTextView shimmerText;
    Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_splash);

        // init constraintLayout
        constraintLayout = (RelativeLayout) findViewById(R.id.constraintLayout);

        shimmer = new Shimmer();
        shimmerText = findViewById(R.id.ejournal);

        shimmer.setRepeatCount(0)
                .setDuration(1500)
                .setStartDelay(2500)
                .setDirection(Shimmer.ANIMATION_DIRECTION_RTL)
                .setAnimatorListener(new Animator.AnimatorListener(){
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
        shimmer.start(shimmerText);

        final RelativeLayout logo = findViewById(R.id.logo_container);
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        final Animation fadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash_screen = new Intent(screen_splash.this , MainActivity.class);
                startActivity(splash_screen);
                finish();
            }
        } , SPLASH_TIME_OUT);


        logo.startAnimation(fadeIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.startAnimation(fadeOut);
            }
            } , 2500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.setVisibility(View.INVISIBLE);
            }
            } , 4000);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }
    }


}

