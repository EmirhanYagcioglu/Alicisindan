package com.cankutboratuncer.alicisindan.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cankutboratuncer.alicisindan.databinding.ActivityForumBinding;

public class ForumFragment extends AppCompatActivity {

    ActivityForumBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForumBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}