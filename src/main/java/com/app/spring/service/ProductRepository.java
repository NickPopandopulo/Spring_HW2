package com.app.spring.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {
    private final List<Product> catalog = new ArrayList<>();

    @PostConstruct
    private void init() {
        catalog.add(new Product("T-shirt", 30.65f));
        catalog.add(new Product("Hat", 10.20f));
        catalog.add(new Product("Socks", 5.35f));
        catalog.add(new Product("Chain", 150.40f));
        catalog.add(new Product("Jeans", 40.00f));
    }

    public Product getProductById(int id) {
        for (Product product : catalog) {
            if (product.getId() == id) {
                return product;
            }
        }
        System.out.println("Product with id = " + id + " is not found");
        return null;
    }

    public void showWholeCatalog() {
        for (Product product : catalog) {
            System.out.println(product);
        }
    }

}
