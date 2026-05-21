package com.example.online_shop;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.online_shop.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 🔹 PRODUCT LIST
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.zara_img, "Stylish Shirt", "$110"));
        products.add(new Product(R.drawable.blue_bag, "Blue Bag", "$120"));
        products.add(new Product(R.drawable.shoes, "Running Shoes", "$90"));
        products.add(new Product(R.drawable.watch, "Smart Watch", "$150"));
        products.add(new Product(R.drawable.stylish_shirt, "Stylish Shirt", "$110"));
        products.add(new Product(R.drawable.blue_bag, "Blue Bag", "$120"));
        products.add(new Product(R.drawable.shoes, "Running Shoes", "$90"));
        products.add(new Product(R.drawable.watch, "Smart Watch", "$150"));

        ProductAdapter productAdapter = new ProductAdapter(products);
        binding.productRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        binding.productRecycler.setAdapter(productAdapter);

        // 🔹 BRAND LIST
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(R.drawable.addidas_logo, "Adidas"));
        brands.add(new Brand(R.drawable.nikilogo, "Nike"));
        brands.add(new Brand(R.drawable.shoes, "Puma"));
        brands.add(new Brand(R.drawable.zaralogo, "Zara"));
        brands.add(new Brand(R.drawable.addidas_logo, "Adidas"));
        brands.add(new Brand(R.drawable.nikilogo, "Nike"));
        brands.add(new Brand(R.drawable.shoes, "Puma"));
        brands.add(new Brand(R.drawable.zaralogo, "Zara"));

        BrandAdapter brandAdapter = new BrandAdapter(brands);
        binding.brandRecycler.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        );
        binding.brandRecycler.setAdapter(brandAdapter);

        // 🔹 BOTTOM NAVIGATION
        binding.bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_profile) {
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
                if (isLoggedIn) {
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                } else {
                    startActivity(new Intent(MainActivity.this, login2.class));
                }
                return true;
            } else if (id == R.id.nav_cart) {
                startActivity(new Intent(MainActivity.this, cart.class));
                return true;
            } else if (id == R.id.nav_wishlist) {
                startActivity(new Intent(MainActivity.this, MessagesActivity.class));
                return true;
            }
            return true;
        });
    }
}