package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class ChangePasswordSuccess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_success);

        Handler handler = new Handler();
        handler.postDelayed(() -> goToLogin(), 2500);
    }

    public void goToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}