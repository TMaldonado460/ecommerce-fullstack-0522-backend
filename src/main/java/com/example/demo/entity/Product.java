package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private String property;
    private Float valoration;

    @OneToMany(mappedBy = "product")
    private Image image;

    @OneToMany(mappedBy = "product")
    private Review review;

    @OneToMany(mappedBy = "product")
    private Cart cart;

}
