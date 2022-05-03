package com.example.demo.dto;

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

public class AdressDTO {
    //Relacion hecha

    private UUID id;
    private String street;
    private Integer locationNumber;
    private String postalCode;


}
