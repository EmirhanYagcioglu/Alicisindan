package com.example.alicisindan_v2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.alicisindan_v2.MainActivity;
import com.example.alicisindan_v2.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button button_SignIn = findViewById(R.id.signIn_button_signIn);
        button_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedSignIn();
            }
        });
    }

    private void clickedSignIn() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }
}