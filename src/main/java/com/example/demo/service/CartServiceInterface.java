package com.example.demo.service;

import com.example.demo.entity.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;

public interface CartServiceInterface {


    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout();

    BigDecimal getTotal();

    void addToCart(Product product, UUID id);
}
