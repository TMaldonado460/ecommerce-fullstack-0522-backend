package com.example.demo.repository;

import com.example.demo.entity.Adress;
import com.example.demo.entity.Product;
import com.example.demo.entity.UserInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query
    List<Product> findByNameContainingOrderByPrice(String infix, Sort sort);


}
