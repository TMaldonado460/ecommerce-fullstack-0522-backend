package com.example.demo.entity;

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
    private Integer stock;
    private String property;
    private Float valoration;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Image> image;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Review> review;



    // Agrego la relación "Many to Many" con clase Bill.
    @ManyToMany(mappedBy = "products",cascade = CascadeType.REMOVE)
    private Set<Bill> bills;

}
