package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController @RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

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
    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id) {
        return productService.findById(id);
    }

    //el body va a ser un json--->array
}
