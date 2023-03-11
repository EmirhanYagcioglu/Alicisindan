package com.cankutboratuncer.alicisindan.activities.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.cankutboratuncer.alicisindan.databinding.ActivityCategoriesBinding;

public class CategoriesFragment extends AppCompatActivity {

    ActivityCategoriesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}