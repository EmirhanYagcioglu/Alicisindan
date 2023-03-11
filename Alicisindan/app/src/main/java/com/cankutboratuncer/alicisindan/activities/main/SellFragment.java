package com.cankutboratuncer.alicisindan.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cankutboratuncer.alicisindan.databinding.ActivitySellBinding;

public class SellFragment extends AppCompatActivity {

    ActivitySellBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySellBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}