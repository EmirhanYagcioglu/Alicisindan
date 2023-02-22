package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        Button resetPasswordButton = findViewById(R.id.button_reset_password);
        TextView hasAccount = findViewById(R.id.text_view_has_account);

        resetPasswordButton.setOnClickListener(view -> goToChangePasswordSuccess());
        hasAccount.setOnClickListener(view -> goToLogin());
    }

    public void goToChangePasswordSuccess() {
        Intent intent = new Intent(this, ChangePasswordSuccess.class);
        startActivity(intent);
    }
    public void goToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}