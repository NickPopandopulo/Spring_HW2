package com.app.spring.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Scope(scopeName = "prototype")
public class Cart {

    private final ProductRepository repository;
    private final List<Product> list = new LinkedList<>();

    private static int CART_COUNT = 0;
    private final String cartName;

    public Cart(ProductRepository repository) {
        this.repository = repository;
        cartName = "Cart №" + (++CART_COUNT);
    }

    public void addProduct(int id) {
        Product product = repository.getProductById(id);
        if (product != null) {
            list.add(product);
            System.out.println("Product with id = " + id + " is added to the " + cartName);
        }
    }

    public void deleteProduct(int id) {
        for (Product product: list) {
            if (product.getId() == id) {
                list.remove(product);
                System.out.println("Product with id = " + id + " is removed from the " + cartName);
                return;
            }
        }
        System.out.println("Product with id = " + id + " is not found in the " + cartName);
    }

    public void showList() {
        System.out.println("Product list in the " + cartName + ":");
        for (Product product : list) {
            System.out.println(product);
        }
    }

}
