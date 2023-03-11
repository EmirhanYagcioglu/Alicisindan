package com.cankutboratuncer.alicisindan.activities.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.cankutboratuncer.alicisindan.databinding.ActivityBuyBinding;

public class BuyFragment extends Fragment {

    ActivityBuyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBuyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}