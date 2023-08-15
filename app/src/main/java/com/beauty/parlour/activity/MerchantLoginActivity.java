package com.beauty.parlour.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.beauty.parlour.MainActivity;
import com.beauty.parlour.R;

public class MerchantLoginActivity extends AppCompatActivity {
    private EditText merchantEditText;
    private AppCompatButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_login);

        merchantEditText = findViewById(R.id.merchantEditText);
        loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = merchantEditText.getText().toString();
                Intent intent = new Intent(MerchantLoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity

                Toast.makeText(MerchantLoginActivity.this, "Logging in...", Toast.LENGTH_SHORT).show();
            }});
    }
}