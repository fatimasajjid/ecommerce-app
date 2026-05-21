package com.example.online_shop;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Product> cartItems = new ArrayList<>();

    private CartManager() {}

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addItem(Product product) {
        cartItems.add(product);
    }

    public List<Product> getItems() {
        return cartItems;
    }

    public int getCount() {
        return cartItems.size();
    }

    public void removeItem(int position) {
        cartItems.remove(position);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double getTotal() {
        double total = 0;
        for (Product p : cartItems) {
            String price = p.getPrice().replace("$", "");
            total += Double.parseDouble(price);
        }
        return total;
    }
}