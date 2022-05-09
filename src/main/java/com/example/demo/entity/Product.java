package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )//TODO
    @Column(nullable = false)
    private UUID id;
    private String name;
    private Double price;
    private String property;
    private Float valoration;

    // varchar 500
    @Column(length = 2000)
    private String description;


    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Image> images;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Stock> stock;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    // Agrego la relación "Many to Many" con clase Cart.
    @ManyToMany(mappedBy = "products", cascade = CascadeType.REMOVE)
    private Set<Cart> carts;

    // Agrego la relación "Many to Many" con clase Bill.
    @ManyToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    private Set<Bill> bills;

}
