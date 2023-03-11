package com.example.alicisindan_v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alicisindan_v2.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signUpButton = findViewById(R.id.signUp_button_signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedSignUp();
            }
        });
    }

    private void clickedSignUp() {
        Intent intent = new Intent(SignUpActivity.this, PhoneNumberActivity.class);
        startActivity(intent);
    }
}