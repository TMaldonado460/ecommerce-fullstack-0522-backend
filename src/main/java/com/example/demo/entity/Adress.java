package com.example.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="adress")
public class Adress {
    //Relacion hecha
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;
    private String street;
    private Integer locationNumber;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name="id_user_info",nullable = false)
    private UserInfo userInfo;
}
