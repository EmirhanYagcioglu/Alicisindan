package com.example.apptest;

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

        loginButton = findViewById(R.id.loginButton);
        loginGoogleButton = findViewById(R.id.loginGoogleButton);
        loginFacebookButton = findViewById(R.id.loginFacebookButton);

        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);

        rememberMeCheckBox = findViewById(R.id.rememberMeCheckBox);

        createAccountText = findViewById(R.id.createAccountText);
        forgotPasswordText = findViewById(R.id.forgotPasswordText);

        forgotPasswordText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSignUp();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginSuccess();
            }
        });
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