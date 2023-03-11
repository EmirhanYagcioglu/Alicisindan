package com.cankutboratuncer.alicisindan.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}

