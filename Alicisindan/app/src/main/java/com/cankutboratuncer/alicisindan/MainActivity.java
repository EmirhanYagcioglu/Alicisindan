package com.cankutboratuncer.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent splashIntent = new Intent(MainActivity.this, SplashActivity.class);
        startActivity(splashIntent);
    }
}

