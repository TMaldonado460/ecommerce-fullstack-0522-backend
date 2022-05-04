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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.PushBuilder;
import java.util.*;

@Service
public class ProductService {

    public ProductService() {
    }
    final static Logger logger = LogManager.getLogger(ProductService.class);
    private ObjectMapper mapper;
    ProductRepository productRepository;
    ReviewRepository reviewRepository;
    BillRepository billRepository;
    CartRepository cartRepository;
    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }
    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Set<ProductDTO> searchALLProducts(){
        List<Product> productList=productRepository.findAll();
        Set<ProductDTO> productListDTO=new HashSet<>();
        for (Product product:productList) {
            productListDTO.add(mapper.convertValue(product,ProductDTO.class));

        }
        return productListDTO;
    }

    //Buscar categoría
    public List<Product> searchByCategory(String category, Sort sort ){
        List<Product> productList=productRepository.findByNameContainingOrderByPrice(category,sort);
        return productList;
    }

    //Buscar review por id del producto
    public List<Review> findAllReviews(UUID productId){
        List<Review> reviewList=reviewRepository.findAllByProduct_id(productId);
        return reviewList;
    }

    // Buscar producto por id
    public Product findById(UUID productId){
        Optional<Product> product=productRepository.findById(productId);
        return product.get();

    }

    public void deleteProduct(UUID productId){
        productRepository.deleteById(productId);
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }









}
