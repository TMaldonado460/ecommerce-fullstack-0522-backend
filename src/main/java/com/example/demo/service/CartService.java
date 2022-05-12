package com.example.demo.service;

import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CartService implements CartServiceInterface {
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private CartRepository cartRepository;

    private Map<Product, Integer> products = new HashMap<>();

    //suerte tomi
    @Override
    public void addProduct(Product product) {
        //si ya existe la key, ponelo en el lugar siguiente
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            //eso ocurre cunado el map no tiene ningun dato
            products.put(product, 1);
        }
    }


    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }

    }
    //ni lo miramos este
    //este lo vamos a usar en User
    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public void checkout() {
    }

    @Override
    public BigDecimal getTotal() {
        return null;
    }

    @Override
    public void addToCart(Product product, UUID id) {
        Cart cart = cartRepository.findByUserInfoId(id);
        cart.addProduct(product);
        cartRepository.save(cart);


    }

}
