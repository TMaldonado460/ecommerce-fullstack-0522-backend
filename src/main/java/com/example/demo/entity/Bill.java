package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Bill {
    //Hacer relacion @Many to many
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;

    // Agrego la relación "Many to One" con la clase UserInfo
    @ManyToOne
    @JoinColumn(name = "id_user_info", nullable = false)
    private UserInfo userInfo;

    // Agrego la relación "Many to Many" con la clase Product
    @ManyToMany
    @JoinTable(name = "bill_product",
            joinColumns = @JoinColumn(name = "id_bill"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    private Set<Product> products;


}
