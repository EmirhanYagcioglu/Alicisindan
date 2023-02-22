package com.alicisindan;

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

        firstNameText = findViewById(R.id.edit_text_first_name);
        String firstName = firstNameText.getText().toString();
        lastNameText = findViewById(R.id.edit_text_last_name);
        String lastName = lastNameText.getText().toString();

        emailText = findViewById(R.id.edit_text_email);
        String email = emailText.getText().toString();
        phoneText = findViewById(R.id.edit_text_phone);
        String phone = phoneText.getText().toString();

        passwordText = findViewById(R.id.edit_text_password);
        String password = passwordText.getText().toString();
        passwordTextCheck = findViewById(R.id.edit_text_password_check);
        String passwordCheck = passwordTextCheck.getText().toString();

        addressText = findViewById(R.id.edit_text_address);
        String address = addressText.getText().toString();
        birthdayText = findViewById(R.id.edit_text_birthday);
        String birthday = birthdayText.getText().toString();

        submitButton = findViewById(R.id.button_submit);
        submitButton.setOnClickListener(view -> trySignUp());

        hasAccountText = findViewById(R.id.text_view_has_account);
        hasAccountText.setOnClickListener(view -> backToLogin());
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