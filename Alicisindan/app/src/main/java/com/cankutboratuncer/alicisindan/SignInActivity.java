package com.cankutboratuncer.alicisindan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}