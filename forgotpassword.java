package com.example.online_shop;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class forgotpassword extends AppCompatActivity {

    private EditText etEmail;
    private Button btnSendLink;
    private TextView tvBackToLogin;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmail = findViewById(R.id.et_email);
        btnSendLink = findViewById(R.id.btn_send_link);
        tvBackToLogin = findViewById(R.id.tv_back_to_login);
        progressBar = findViewById(R.id.progress_bar);

        btnSendLink.setOnClickListener(v -> sendResetLink());
        tvBackToLogin.setOnClickListener(v -> finish());
    }

    private void sendResetLink() {
        String email = etEmail.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter your email");
            etEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please enter a valid email");
            etEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        btnSendLink.setEnabled(false);

        etEmail.postDelayed(() -> {
            progressBar.setVisibility(View.GONE);
            btnSendLink.setEnabled(true);
            Toast.makeText(this, "Reset link sent to " + email, Toast.LENGTH_LONG).show();
            finish();
        }, 1500);
    }
}