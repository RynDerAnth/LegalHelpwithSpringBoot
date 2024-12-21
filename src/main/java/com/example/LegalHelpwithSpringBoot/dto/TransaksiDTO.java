package com.example.LegalHelpwithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransaksiDTO {
    private int id;
    private String sender;
    private String receiver;
    private double jumlah;
}
