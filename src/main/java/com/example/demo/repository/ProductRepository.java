package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query
    List<Product> findAllByNameContainingOrderByPrice(String infix, Sort sort); // TODO cambiado el nombre a find all porque traemos todos los productos de la categoría elegida


}
