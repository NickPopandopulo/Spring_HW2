package com.app.spring.service;

import com.app.spring.configuration.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. Есть класс Product (id, название, цена). Товары хранятся в бине ProductRepository, в виде List<Product>, при
 * старте в него нужно добавить 5 любых товаров.
 *
 * 2. ProductRepository позволяет получить весь список или один товар по id. Создаем бин Cart, в который можно
 * добавлять и удалять товары по id.
 *
 * 3. При каждом запросе корзины из контекста, должна создаваться новая корзина.
 */

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class)) {
            ProductRepository repository = context.getBean(ProductRepository.class);
            Cart cart1 = context.getBean(Cart.class);
            Cart cart2 = context.getBean(Cart.class);
            cart1.addProduct(1);
            cart2.addProduct(1);
            cart1.addProduct(2);
            cart2.addProduct(2);
            cart1.addProduct(3);
            cart2.addProduct(3);
            cart1.showList();
            cart2.showList();
            cart1.deleteProduct(2);
            cart2.deleteProduct(2);
            cart1.showList();
            cart2.showList();
        }
    }
}
