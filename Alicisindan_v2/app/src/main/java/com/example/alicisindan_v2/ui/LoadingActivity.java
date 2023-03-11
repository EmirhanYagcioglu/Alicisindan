package com.example.alicisindan_v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.alicisindan_v2.R;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Handler handler = new Handler();
        handler.postDelayed(() -> goToLogin(), 2000);
    }

    public void goToLogin() {
        Intent intent = new Intent(LoadingActivity.this, WelcomeActivity.class);
        startActivity(intent);
    }
}