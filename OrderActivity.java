package com.example.online_shop;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView orderProductName = findViewById(R.id.orderProductName);
        TextView orderProductPrice = findViewById(R.id.orderProductPrice);
        EditText etName = findViewById(R.id.etName);
        EditText etPhone = findViewById(R.id.etPhone);
        EditText etAddress = findViewById(R.id.etAddress);
        EditText etCity = findViewById(R.id.etCity);
        RadioGroup radioPayment = findViewById(R.id.radioPayment);
        Button btnPlaceOrder = findViewById(R.id.btnPlaceOrder);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");

        orderProductName.setText(name);
        orderProductPrice.setText(price);

        btnPlaceOrder.setOnClickListener(v -> {
            String fullName = etName.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String address = etAddress.getText().toString().trim();
            String city = etCity.getText().toString().trim();

            if (TextUtils.isEmpty(fullName)) {
                etName.setError("Name required");
                etName.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(phone)) {
                etPhone.setError("Phone required");
                etPhone.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(address)) {
                etAddress.setError("Address required");
                etAddress.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(city)) {
                etCity.setError("City required");
                etCity.requestFocus();
                return;
            }

            int selectedPayment = radioPayment.getCheckedRadioButtonId();
            String paymentMethod = "Cash on Delivery";
            if (selectedPayment == R.id.radioEasypaisa) {
                paymentMethod = "Easypaisa";
            } else if (selectedPayment == R.id.radioJazzCash) {
                paymentMethod = "JazzCash";
            }

            Intent intent = new Intent(OrderActivity.this, OrderConfirmation.class);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            intent.putExtra("fullName", fullName);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("city", city);
            intent.putExtra("payment", paymentMethod);
            startActivity(intent);
        });
    }
}