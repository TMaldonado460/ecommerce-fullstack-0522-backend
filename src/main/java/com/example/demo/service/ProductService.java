package com.example.demo.service;

import com.example.demo.dto.ArrayProductDTO;
import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.*;
import com.example.demo.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static com.example.demo.util.MapperUtil.mapList;

@Service
public class ProductService {

    public ProductService() {
    }
    final static Logger logger = LogManager.getLogger(ProductService.class);
    @Autowired
    MapperUtil mapList;
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
    public List<ImageDTO> findAllImages(UUID product_id){
        List<Image> imageList=imageRepository.findAllByProduct_id(product_id);
        List<ImageDTO> imageDTOList=new ArrayList<>();
        for (Image image:imageList) {
            imageDTOList.add(mapper.convertValue(image, ImageDTO.class));
        }
        return imageDTOList;
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
    @Transactional //Esto sirve para que no guarde si no está todo bien. Sin esto, guarda algunos.Preferis que te guarde nada en vez de incompleto
    public List<ProductDTO> saveAllProducts(List<ProductDTO> productsDTO){
        List<Product> productList = mapList(productsDTO,Product.class);
        List<Product> productListSaved=productRepository.saveAll(productList);
        List<ProductDTO> productListDTO=new ArrayList<>();
        for (Product product1:productList) {
            productListDTO.add(mapper.convertValue(productListSaved, ProductDTO.class));
        }
        return productListDTO;
    }

//    Paciente paciente= mapper.convertValue(pacienteDTO,Paciente.class);
//    Paciente pacienteGuardado=pacienteRepository.save(paciente);
//        return mapper.convertValue(pacienteGuardado,PacienteDTO.class);










}
