package com.cankutboratuncer.alicisindan.activities.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cankutboratuncer.alicisindan.databinding.ActivityPhoneBinding;

public class PhoneActivity extends AppCompatActivity {

    ActivityPhoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}