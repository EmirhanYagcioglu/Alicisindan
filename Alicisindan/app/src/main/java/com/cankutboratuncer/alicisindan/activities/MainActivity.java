package com.cankutboratuncer.alicisindan.activities;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cankutboratuncer.alicisindan.R;
import com.cankutboratuncer.alicisindan.activities.ui.main.buy.BuyFragment;
import com.cankutboratuncer.alicisindan.activities.ui.main.forum.ForumFragment;
import com.cankutboratuncer.alicisindan.activities.ui.main.home.HomeFragment;
import com.cankutboratuncer.alicisindan.activities.ui.main.profile.ProfileFragment;
import com.cankutboratuncer.alicisindan.activities.ui.main.sell.SellFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.mainActivity_bottomNavigationBar_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        if (item.getItemId() == R.id.menu_home) {
            fragment = new HomeFragment();

        } else if (item.getItemId() == R.id.menu_buy) {
            fragment = new BuyFragment();
        } else if (item.getItemId() == R.id.menu_sell) {
            fragment = new SellFragment();
        } else if (item.getItemId() == R.id.menu_forum) {
            fragment = new ForumFragment();
        } else if (item.getItemId() == R.id.menu_profile) {
            fragment = new ProfileFragment();
        }

        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }

    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.mainActivity_frameLayout_main, fragment).addToBackStack(null).commit();
    }
}
