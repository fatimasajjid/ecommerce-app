package com.example.online_shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderConfirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        TextView confirmName = findViewById(R.id.confirmName);
        TextView confirmPrice = findViewById(R.id.confirmPrice);
        TextView confirmAddress = findViewById(R.id.confirmAddress);
        TextView confirmPayment = findViewById(R.id.confirmPayment);
        Button btnBackHome = findViewById(R.id.btnBackHome);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String fullName = getIntent().getStringExtra("fullName");
        String address = getIntent().getStringExtra("address");
        String city = getIntent().getStringExtra("city");
        String payment = getIntent().getStringExtra("payment");

        confirmName.setText(name);
        confirmPrice.setText(price);
        confirmAddress.setText(fullName + "\n" + address + ", " + city);
        confirmPayment.setText("Payment: " + payment);

        btnBackHome.setOnClickListener(v -> {
            Intent intent = new Intent(OrderConfirmation.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });
    }
}