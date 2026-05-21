package com.example.online_shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailName = findViewById(R.id.detailName);
        TextView detailPrice = findViewById(R.id.detailPrice);
        Button btnAddToCart = findViewById(R.id.btnAddToCart);
        Button btnOrderNow = findViewById(R.id.btnOrderNow);

        int image = getIntent().getIntExtra("image", 0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");

        Product product = new Product(image, name, price);

        detailImage.setImageResource(image);
        detailName.setText(name);
        detailPrice.setText(price);

        btnAddToCart.setOnClickListener(v -> {
            CartManager.getInstance().addItem(product);
            Toast.makeText(this, name + " added to cart!", Toast.LENGTH_SHORT).show();
        });

        btnOrderNow.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetail.this, OrderActivity.class);
            intent.putExtra("image", image);
            intent.putExtra("name", name);
            intent.putExtra("price", price);
            startActivity(intent);
        });
    }
}