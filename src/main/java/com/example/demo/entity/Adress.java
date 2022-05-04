package com.example.demo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="adress")
public class Adress {
    //Relacion hecha
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(nullable = false)
    private UUID id;
    private String street;
    private Integer locationNumber;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name="id_user_info",nullable = false)
    private UserInfo userInfo;
}
