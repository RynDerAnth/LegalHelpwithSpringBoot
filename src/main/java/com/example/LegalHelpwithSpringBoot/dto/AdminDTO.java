package com.example.LegalHelpwithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private int id;
    private String nama;
    private String email;
    private String hp;
}