package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ProductDTO {
    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private String property;
    private Float valoration;



}
