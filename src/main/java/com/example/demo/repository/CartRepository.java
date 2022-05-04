package com.example.demo.repository;

import com.example.demo.entity.Adress;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {

}
