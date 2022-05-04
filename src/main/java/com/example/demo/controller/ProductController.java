package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // TODO listar productos por categoría seleccionada
//    @PostMapping("/category/{categoryId}")
//    public List<Product> getProductsByCategory(@PathVariable String categoryId, @RequestBody String body) {
//        Sort sort = null;
//        switch (body) {
//            case "asc":
//                sort = Sort.by("name").ascending();
//                break;
//            case "desc":
//                sort = Sort.by("name").descending();
//                break;
//            default:
//                sort = Sort.by("name").ascending();
//        }
//    }

    // CRUD
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    //el body va a ser un json--->array

    // TODO Get all

    // TODO Put (update)

    // TODO Delete
}
