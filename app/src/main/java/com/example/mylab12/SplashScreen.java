package com.example.mylab12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT=6000;
    MediaPlayer ourSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ourSound = MediaPlayer.create(getApplicationContext(),R.raw.song1);
        ourSound.start();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this,OnboardingScreen.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);

        Thread timer=new Thread()
        {
            public void run()
            {
                try {
                    sleep(5000);
                }catch (InterruptedException e)
                {
                    Thread.currentThread().interrupt();
                }
            }
        };timer.start();
    }
    protected void onPause()
    {
        super.onPause();
        ourSound.release();
        finish();
    }
}