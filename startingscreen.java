package com.example.online_shop;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.online_shop.databinding.ActivityStartingscreenBinding;

public class startingscreen extends AppCompatActivity {

    private ActivityStartingscreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartingscreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnGetStarted.setOnClickListener(v -> {
            startActivity(new Intent(startingscreen.this, MainActivity.class));
            finish();
        });
    }
}