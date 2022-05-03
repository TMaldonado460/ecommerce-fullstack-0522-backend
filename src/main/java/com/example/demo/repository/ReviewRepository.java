package com.example.demo.repository;

import com.example.demo.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ReviewRepository extends JpaRepository<ReviewRepository, UUID> {
}
