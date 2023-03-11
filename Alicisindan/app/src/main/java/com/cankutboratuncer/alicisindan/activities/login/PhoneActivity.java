package com.cankutboratuncer.alicisindan.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.cankutboratuncer.alicisindan.activities.main.MainActivity;
import com.cankutboratuncer.alicisindan.databinding.ActivityPhone2Binding;

public class PhoneActivity extends AppCompatActivity {

    ActivityPhone2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhone2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonVerification.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PhoneVerificationActivity.class)));
        binding.buttonSignIn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SignInActivity.class)));
    }
}