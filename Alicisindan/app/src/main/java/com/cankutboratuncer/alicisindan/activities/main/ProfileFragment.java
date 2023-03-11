package com.cankutboratuncer.alicisindan.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cankutboratuncer.alicisindan.databinding.ActivityProfileBinding;

public class ProfileFragment extends AppCompatActivity {

    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}