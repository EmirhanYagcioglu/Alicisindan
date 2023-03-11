package com.cankutboratuncer.alicisindan.activities.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.activities.main.MainActivity;
import com.cankutboratuncer.alicisindan.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {

    ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonSignIn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        binding.buttonSignUp.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), PhoneActivity.class)));
    }
}