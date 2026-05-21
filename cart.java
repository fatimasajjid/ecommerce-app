package com.example.online_shop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class cart extends AppCompatActivity {
    private ListView cartListView;
    private TextView tvTotal;
    private LinearLayout tvEmpty;
    private LinearLayout bottomCheckout;
    private Button btnCheckout;
    private Button shopNowBtn;
    private ImageView deleteIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        tvTotal = findViewById(R.id.tvTotal);
        tvEmpty = findViewById(R.id.tvEmpty);
        bottomCheckout = findViewById(R.id.bottomCheckout);
        btnCheckout = findViewById(R.id.btnCheckout);
        shopNowBtn = findViewById(R.id.shopNowBtn);
        deleteIcon = findViewById(R.id.deleteIcon);
        deleteIcon.setColorFilter(Color.WHITE);

        loadCart();

        // Shop Now button
        shopNowBtn.setOnClickListener(v -> {
            Intent intent = new Intent(cart.this, MainActivity.class);
            startActivity(intent);
        });

        // Delete icon — cart clear karo
        deleteIcon.setOnClickListener(v -> {
            if (CartManager.getInstance().getCount() == 0) {
                Toast.makeText(this, "Cart already empty!", Toast.LENGTH_SHORT).show();
            } else {
                CartManager.getInstance().clearCart();
                loadCart();
                Toast.makeText(this, "Cart cleared!", Toast.LENGTH_SHORT).show();
            }
        });

        // Checkout button
        btnCheckout.setOnClickListener(v -> {
            if (CartManager.getInstance().getCount() == 0) {
                Toast.makeText(this, "Cart is empty!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show();
                CartManager.getInstance().clearCart();
                loadCart();
            }
        });
    }

    private void loadCart() {
        List<Product> items = CartManager.getInstance().getItems();
        if (items.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            cartListView.setVisibility(View.GONE);
            bottomCheckout.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            cartListView.setVisibility(View.VISIBLE);
            bottomCheckout.setVisibility(View.VISIBLE);
            String[] itemNames = new String[items.size()];
            for (int i = 0; i < items.size(); i++) {
                itemNames[i] = "  " + items.get(i).getName() + "  —  " + items.get(i).getPrice();
            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, itemNames);
            cartListView.setAdapter(adapter);
            tvTotal.setText("$" + String.format("%.2f", CartManager.getInstance().getTotal()));
        }
    }
}