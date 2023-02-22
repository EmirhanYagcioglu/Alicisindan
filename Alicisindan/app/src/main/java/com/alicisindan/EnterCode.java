package com.alicisindan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EnterCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);

        Button resetPasswordButton = findViewById(R.id.button_submit);
        TextView hasAccount = findViewById(R.id.text_view_has_account);

        resetPasswordButton.setOnClickListener(view -> goToChangePassword());
        hasAccount.setOnClickListener(view -> goToLogin());
    }

    public void goToChangePassword() {
        Intent intent = new Intent(this, ChangePassword.class);
        startActivity(intent);
    }
    public void goToLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}