package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    private Button submitButton;
    private EditText firstNameText, lastNameText, emailText, phoneText, passwordText, passwordTextCheck, addressText, birthdayText;
    private CheckBox tacCheck;
    private TextView hasAccountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firstNameText = findViewById(R.id.firstNameText);
        String firstName = firstNameText.getText().toString();
        lastNameText = findViewById(R.id.lastNameText);
        String lastName = lastNameText.getText().toString();

        emailText = findViewById(R.id.emailText);
        String email = emailText.getText().toString();
        phoneText = findViewById(R.id.phoneText);
        String phone = phoneText.getText().toString();

        passwordText = findViewById(R.id.passwordText);
        String password = passwordText.getText().toString();
        passwordTextCheck = findViewById(R.id.passwordTextCheck);
        String passwordCheck = passwordTextCheck.getText().toString();

        addressText = findViewById(R.id.addressText);
        String address = addressText.getText().toString();
        birthdayText = findViewById(R.id.birthdayText);
        String birthday = birthdayText.getText().toString();

        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trySignUp();
            }
        });

        hasAccountText = findViewById(R.id.hasAccountText);
        hasAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToLogin();
            }
        });
    }

    public void trySignUp() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void backToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}