package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name="product")
public class Product {
    // suerte facu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;
    private String name;
    private Double price;
    private Integer stock;
    private String property;
    private Float valoration;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private Image image;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private Review review;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private Cart cart;

    // Agrego la relación "Many to Many" con clase Bill.
    @ManyToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    private Set<Bill> bills;

}
