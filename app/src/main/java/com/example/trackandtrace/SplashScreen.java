package com.example.trackandtrace;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT =700;
    ImageView sicon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent I = new Intent(SplashScreen.this,Login.class);
                startActivity(I);
                finish();
            }
        },SPLASH_TIME_OUT);

        sicon= findViewById(R.id.sicon);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                sicon, PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );

        objectAnimator.setDuration(500);

        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);

        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        objectAnimator.start();

    }

}