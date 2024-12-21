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
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sender;
    private String receiver;
    private double jumlah;

    public Transaksi(String sender, String receiver, double jumlah) {
        this.sender = sender;
        this.receiver = receiver;
        this.jumlah = jumlah;
    }
}
