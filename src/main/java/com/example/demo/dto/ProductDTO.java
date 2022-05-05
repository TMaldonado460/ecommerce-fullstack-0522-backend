package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ProductDTO {
    // suerte facu

    private UUID id;
    private String name;
    private Double price;
    private Integer stock; // esto no se va a mandar a la vista
    private String property;
    private Float valoration;

    // array de imagenes falta
    // lo ideal seria tener 2 dto de producto, despues les comento como funcionaria, de momento el productDTO
    // solo tiene una imagen -- Tomi



}
