package com.example.online_shop;

public class Product {
    int image;
    String name;
    String price;

    public Product(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public int getImage() { return image; }
    public String getName() { return name; }
    public String getPrice() { return price; }
}