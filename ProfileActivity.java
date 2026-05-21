package com.example.online_shop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        String email = prefs.getString("email", "");
        String phone = prefs.getString("phone", "");

        TextView tvEmail = findViewById(R.id.tvProfileEmail);
        TextView tvEmail2 = findViewById(R.id.tvProfileEmail2);
        TextView tvPhone = findViewById(R.id.tvProfilePhone);
        Button btnLogout = findViewById(R.id.btnLogout);

        tvEmail.setText(email);
        tvEmail2.setText(email.isEmpty() ? "Not provided" : email);
        tvPhone.setText(phone.isEmpty() ? "Not provided" : phone);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(ProfileActivity.this, login2.class));
            finish();
        });
    }
}