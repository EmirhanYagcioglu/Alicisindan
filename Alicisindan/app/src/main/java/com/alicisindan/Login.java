package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private Button loginButton, loginGoogleButton, loginFacebookButton;
    private EditText usernameText, passwordText;
    private CheckBox rememberMeCheckBox;
    private TextView createAccountText, forgotPasswordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.button_login);
        loginGoogleButton = findViewById(R.id.button_google_login);
        loginFacebookButton = findViewById(R.id.button_facebook_login);

        usernameText = findViewById(R.id.edit_text_username);
        passwordText = findViewById(R.id.edit_text_password);

        rememberMeCheckBox = findViewById(R.id.checkbox_remember_me);

        createAccountText = findViewById(R.id.text_view_create_account);
        forgotPasswordText = findViewById(R.id.text_view_forgot_password);

        forgotPasswordText.setOnClickListener(view -> resetPassword());
        createAccountText.setOnClickListener(view -> gotoSignUp());
        loginButton.setOnClickListener(view -> loginSuccess());
    }

    public void resetPassword() {
        Intent intent = new Intent(this, PasswordReset.class);
        startActivity(intent);
    }
    public void gotoSignUp() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    public void loginSuccess(){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
}