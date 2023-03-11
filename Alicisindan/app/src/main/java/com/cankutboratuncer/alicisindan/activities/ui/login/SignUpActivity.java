package com.cankutboratuncer.alicisindan.activities.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.cankutboratuncer.alicisindan.activities.MainActivity;
import com.cankutboratuncer.alicisindan.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonSignUp.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
        binding.buttonSignIn.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), SignInActivity.class)));
    }
}