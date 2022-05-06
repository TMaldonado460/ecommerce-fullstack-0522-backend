package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ImageDTO {
    //relaciones hechas

    private UUID id;
    private String url;
    private Integer type; // 1 miniatura, 2 imagen grande, 3 imagen pequeña (miniatura es una imagen pequeña)



}
