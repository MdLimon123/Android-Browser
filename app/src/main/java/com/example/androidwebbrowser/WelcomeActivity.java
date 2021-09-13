package com.example.androidwebbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Thread th = new Thread()
        {

            public void run(){

                try {

                    sleep(500);
                }
                catch (Exception e){
                    e.printStackTrace();

                }finally {

                    Intent home = new Intent(WelcomeActivity.this,HomeActivity.class);
                    startActivity(home);

                }

            }

        };
        th.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}