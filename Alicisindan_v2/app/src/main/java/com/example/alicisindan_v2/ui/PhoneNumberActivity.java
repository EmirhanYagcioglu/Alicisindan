package com.example.alicisindan_v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alicisindan_v2.R;

public class PhoneNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        Button sendVerificationButton = findViewById(R.id.phoneNumber_button_sendVerificationCode);
        sendVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_sendVerification();
            }
        });
    }

    private void clicked_sendVerification() {
        Intent intent = new Intent(PhoneNumberActivity.this, VerificationActivity.class);
        startActivity(intent);
    }
}