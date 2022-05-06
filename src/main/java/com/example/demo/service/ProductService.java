package com.example.demo.service;

import com.example.demo.dto.ArrayProductDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    ImageRepository imageRepository;
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
    public Set<ArrayProductDTO> searchALLProducts(){
        List<Product> productList=productRepository.findAll();
        Set<ArrayProductDTO> productListDTO=new HashSet<>();
        for (Product product:productList) {
            productListDTO.add(mapper.convertValue(product, ArrayProductDTO.class));

        }
        return productListDTO;
    }

    //Buscar categoría
    public List<Product> searchByCategory(String category, Sort sort ){
        List<Product> productList=productRepository.findByNameContainingOrderByPrice(category,sort);
        return productList;
    }

    //Buscar review por id del producto
    public List<Review> findAllReviews(UUID product_id){
        List<Review> reviewList=reviewRepository.findAllByProduct_id(product_id);
        return reviewList;
    }
    public List<Image> findAllImages(UUID product_id){
        List<Image> imageList= imageRepository.findAllByProduct_id(product_id);
        return imageList;
    }

    // Buscar producto por id
    public ProductDTO findById(UUID productId){
        Optional<Product> product=productRepository.findById(productId);
        ProductDTO productDTO=null;
        if(product.isPresent()){
            productDTO=mapper.convertValue(product.get(), ProductDTO.class);
        }
        return productDTO;

    }



    public void deleteProduct(UUID productId){
        productRepository.deleteById(productId);
    }

    public List<Product> saveAllProducts(List<Product> product){
        return productRepository.saveAll(product);
    }










}
