package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PasswordReset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);

        Button nextButton = findViewById(R.id.button_next);
        TextView hasAccount = findViewById(R.id.text_view_has_account);

        nextButton.setOnClickListener(view -> goToEnterCode());
        hasAccount.setOnClickListener(view -> goToLogin());
    }

    public void goToEnterCode() {
        Intent intent = new Intent(this, EnterCode.class);
        startActivity(intent);
    }
    public void goToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}