package com.example.demo.repository;

import com.example.demo.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdressRepository extends JpaRepository<Adress, UUID> {
//    @Query
//    Adress findByUserId(UUID userId) ;
@Query
    Adress findByUserInfoId(UUID userId);
}
