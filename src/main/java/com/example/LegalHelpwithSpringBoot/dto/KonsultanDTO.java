package com.example.LegalHelpwithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KonsultanDTO {
    private int id;
    private String nama;
    private double harga;
}
