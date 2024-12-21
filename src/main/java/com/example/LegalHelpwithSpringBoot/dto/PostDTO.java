package com.example.LegalHelpwithSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int id;
    private String penulis;
    private String konten;
    private String tanggal;
}
