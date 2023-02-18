package com.cankutboratuncer.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEmail, password;
    CheckBox remember;
    Button signIn, googleSignIn, facebookSignIn;

    TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findWidgets();
    }

    @Override
    protected void onStart() {
        super.onStart();
        signUpButtonListenner();
    }

    private void signUpButtonListenner() {
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUpIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(signUpIntent);
            }
        });
    }

    private void findWidgets() {
        this.usernameEmail = findViewById(R.id.edit_text_username_email);
        this.password = findViewById(R.id.edit_text_password);
        this.remember = findViewById(R.id.check_box_remember);
        this.signIn = findViewById(R.id.button_sign_in);
        this.googleSignIn = findViewById(R.id.button_google);
        this.facebookSignIn = findViewById(R.id.button_facebook);
        this.signUp = findViewById(R.id.text_view_sign_up);
    }
}