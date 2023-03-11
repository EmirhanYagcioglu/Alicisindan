package com.example.alicisindan_v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alicisindan_v2.R;

public class VerificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        Button verifyButton = findViewById(R.id.verification_button_verify);
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicked_verify();
            }
        });
    }

    private void clicked_verify() {
        Intent intent = new Intent(VerificationActivity.this, SignInActivity.class);
        startActivity(intent);
    }
}