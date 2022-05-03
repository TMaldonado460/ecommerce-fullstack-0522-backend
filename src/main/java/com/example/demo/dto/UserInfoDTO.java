package com.example.demo.dto;

import lombok.*;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserInfoDTO {
    // suerte facu
    private UUID id;
    private String email;
    private String name;



}
