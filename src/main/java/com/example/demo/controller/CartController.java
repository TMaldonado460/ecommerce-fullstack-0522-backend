package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.security.entity.UserInfo;
import com.example.demo.service.CartService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("cart")
public class CartController {


    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;



    @PostMapping("/")
    public void addToCart(Product product) {
        //aca consigue el usuario de la peticion
        UserInfo userInfo= (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        cartService.addToCart(product, userInfo.getId());

    }


}
