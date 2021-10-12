package com.app.spring.service;

public class Product {
    private int id;
    private String name;
    private float price;
    private static int ID_COUNT = 0;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
        id = ++ID_COUNT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                '}';
    }
}
