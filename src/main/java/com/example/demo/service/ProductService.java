package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.ReviewDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CartRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    public ProductService() {
    }
    final static Logger logger = LogManager.getLogger(ProductService.class);
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private ObjectMapper mapper;

    ReviewRepository reviewRepository;
    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    BillRepository billRepository;

    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    CartRepository cartRepository;

    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Set<ProductDTO> searchALLProducts(){
        List<Product> productList=productRepository.findAll();
        Set<ProductDTO> productListDTO=new HashSet<>();
        for (Product product:productList) {
            productListDTO.add(mapper.convertValue(product,ProductDTO.class));

        }
        return productListDTO;
    }

    public Set<ReviewDTO> searchAllReviews(UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        List<Review> reviewList = reviewRepository.findAll();
        Set<ReviewDTO> reviewListDTO = new HashSet<>();
        if (product.isPresent()) {
            for (Review review : reviewList) {
                reviewListDTO.add(mapper.convertValue(review, ReviewDTO.class));
            }
        }
        return reviewListDTO;

    }


    public List<Product> addProductToCart(Product product,UUID productId){
        Optional<Product> productToSave = productRepository.findById(productId);
        List<Product> cart=new ArrayList<>();
        if(productToSave.isPresent()){
            cart.add(product);
        }
        return cart;




    }




}
