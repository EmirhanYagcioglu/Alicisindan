package com.cankutboratuncer.alicisindan.activities.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.databinding.ActivityLoadingBinding;

public class LoadingActivity extends AppCompatActivity {
    ActivityLoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}