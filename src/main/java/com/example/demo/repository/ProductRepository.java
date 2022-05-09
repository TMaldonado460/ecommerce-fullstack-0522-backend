package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query
    Page<Product> findByPropertyContaining(String property, Pageable pageable);
    // "... - CategoriaRunning - ..."
    // Page<Product> findByPropertyContaining("MarcaNike", PageRequest.of(2, 25, Sort.by("price").ascending()));
    long count();

    @Query
    long countByProperty(String property);

}
