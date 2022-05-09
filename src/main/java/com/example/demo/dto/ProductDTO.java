package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)


public class ProductDTO {
    private UUID id;
    private String name;
    private Double price;
    // private Integer stock; // esto no se va a mandar a la vista
    private String property; //sirve que esto este en el dto?
    private Float valoration;
    private Set<ReviewDTO> reviews;
    private Set<ImageDTO> images;
    private Set<StockDTO> stock;

    private String description;
}
