package com.example.online_shop;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BrandProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_products);

        String brandName = getIntent().getStringExtra("brandName");
        int brandImage = getIntent().getIntExtra("brandImage", 0);

        TextView tvBrandName = findViewById(R.id.tvBrandName);
        ImageView brandLogo = findViewById(R.id.brandLogo);
        ImageView btnBack = findViewById(R.id.btnBack);
        RecyclerView recyclerView = findViewById(R.id.brandProductsRecycler);

        tvBrandName.setText(brandName + " Products");
        brandLogo.setImageResource(brandImage);

        btnBack.setOnClickListener(v -> finish());

        // Products for this brand
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.shirt1, brandName + " Shirt", "$110"));
        products.add(new Product(R.drawable.jacket, brandName + " Jacket", "$150"));
        products.add(new Product(R.drawable.shoes1, brandName + " Shoes", "$90"));
        products.add(new Product(R.drawable.cap, brandName + " Cap", "$40"));
        products.add(new Product(R.drawable.bags, brandName + " Bag", "$120"));
        products.add(new Product(R.drawable.shorts, brandName + " Shorts", "$60"));

        ProductAdapter adapter = new ProductAdapter(products);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }
}
