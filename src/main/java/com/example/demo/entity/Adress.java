package com.example.demo.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;
}
