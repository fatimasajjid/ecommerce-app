package com.example.online_shop;

public class Brand {
    int image;
    String name;

    public Brand(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() { return image; }
    public String getName() { return name; }
}