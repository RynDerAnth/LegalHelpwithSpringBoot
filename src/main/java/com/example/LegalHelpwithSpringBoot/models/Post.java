package com.example.LegalHelpwithSpringBoot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String penulis;
    private String konten;
    private String tanggal;

    public Post(String penulis, String konten, String tanggal) {
        this.penulis = penulis;
        this.konten = konten;
        this.tanggal = tanggal;
    }
}
