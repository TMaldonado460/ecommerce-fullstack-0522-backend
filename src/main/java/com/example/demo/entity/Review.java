package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Review {
    //todas hechas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;


    @ManyToOne
    @JoinColumn(name="id_user_info",nullable = false)
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name="product",nullable = false)
    private Product product;
}
