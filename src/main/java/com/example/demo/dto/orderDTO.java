package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class orderDTO {
    private String orderAttribute; // nombre por ej
    private Integer offset; // cantidad de elementos por pagina
    private String orderDirection; //asc o dsc

}
