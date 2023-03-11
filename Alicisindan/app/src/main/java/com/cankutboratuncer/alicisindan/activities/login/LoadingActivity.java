package com.cankutboratuncer.alicisindan.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.databinding.ActivityLoadingBinding;

public class LoadingActivity extends AppCompatActivity {
    ActivityLoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Handler handler = new Handler();
        handler.postDelayed(() -> goToLogin(), 2000);
    }
    public void goToLogin() {
        Intent intent = new Intent(LoadingActivity.this, SplashActivity.class);
        startActivity(intent);
    }
}


