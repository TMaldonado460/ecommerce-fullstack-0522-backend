package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_info")
public class UserInfo {
    // suerte facu
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private UUID id;
    private String email;
    private String name;



    @OneToMany(mappedBy = "userInfo")
    private Adress adress;

    @OneToMany(mappedBy = "userInfo")
    private Cart cart;




}
