package com.example.demo.repository;

import com.example.demo.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {
    @Query
    List<Image> findAllByProductId(UUID id); // TODO Cambiado el nombre a find all porque traemos todas las imágenes de un producto (y además había un _ en la firma del método 😮

}
