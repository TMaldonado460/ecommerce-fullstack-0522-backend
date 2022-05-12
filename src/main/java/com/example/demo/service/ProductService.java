package com.example.demo.service;

import com.example.demo.dto.ArrayProductDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.ImageDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Image;
import com.example.demo.entity.Product;
import com.example.demo.entity.Review;
import com.example.demo.repository.*;
import com.example.demo.util.MapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
            ArrayProductDTO productDTO=mapper.convertValue(product, ArrayProductDTO.class);
            Optional<Image> image = imageRepository.findTopByProduct_Id(product.getId());
            if (image.isPresent()) {
                productDTO.setImage(mapper.convertValue(image.get(), ImageDTO.class));
            }
            productListDTO.add(productDTO);
        }
        return productListDTO;
    }

    //Buscar categoría
    public List<Product> searchByCategory(String category, Sort sort ){
        //List<Product> productList=productRepository.findByNameContainingOrderByPrice(category,sort);
        return null;
    }

    public List<ArrayProductDTO> findAllProducts(String property,Pageable pageable) {
        Page<Product> productPage = productRepository.findByPropertyContaining(property,pageable);
        List<ArrayProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productPage) {
            ArrayProductDTO productDTO = mapper.convertValue(product, ArrayProductDTO.class);
            Optional<Image> image = imageRepository.findTopByProduct_Id(product.getId());
            if (image.isPresent()) {
                productDTO.setImage(mapper.convertValue(image.get(), ImageDTO.class));
            }
            productDTOList.add(productDTO);
        }


        return productDTOList;
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
    @Transactional //Esto sirve para que no guarde si no está todo bien. Sin esto, guarda algunos.Preferis que NO te guarde nada en vez de incompleto
    public List<ProductDTO> saveAllProducts(List<ProductDTO> productsDTO){
        List<Product> productList = MapperUtil.mapList(productsDTO,Product.class);
        List<Product> productListSaved=productRepository.saveAll(productList);
        List<ProductDTO> productListDTO = MapperUtil.mapList(productListSaved,ProductDTO.class);
        return productListDTO;
    }

    public long getNumberOfProducts(String property){
        if(property==null){
            return productRepository.count();
        }
        return productRepository.count();
    }

    public long countByProperty(String property){
        return productRepository.countByProperty(property);
    }



    public List<CartDTO> findCartByUser(UUID userId){
        List<Cart> cartList=cartRepository.findByUserInfoId(userId);
        List<CartDTO> cartDTOList=new ArrayList<>();
        for (Cart cart:cartList) {
            cartDTOList.add(mapper.convertValue(cart, CartDTO.class));
        }
        return cartDTOList;
    }

    public List<Cart> addProductToCartList(UUID userId,UUID productId){
        List<Cart> cartList=cartRepository.findByUserInfoId(userId);
        List<Cart> cartListForProduct=cartRepository.addProductToCart(userId,productId);

        for (Cart cart:cartList) {
            cartList

        }
        return cartDTOList;
    }













}
