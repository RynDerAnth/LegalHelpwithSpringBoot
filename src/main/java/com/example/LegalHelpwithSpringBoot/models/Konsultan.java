package com.example.LegalHelpwithSpringBoot.models;

import java.util.ArrayList;
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
@Table(name = "konsultan")
public class Konsultan {
    private ArrayList<Transaksi> listTransaksi = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String nama;
    double harga;

    public Konsultan(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void receiveBooking(Transaksi transaksi) {
        listTransaksi.add(transaksi);
    }
    
    public void historiTransaksi() {
        for (Transaksi t : listTransaksi) {
            System.out.println("ID transaksi: " + t.getId() + "\nPenerima: " + t.getReceiver() + "\nJumlah: " + t.getJumlah());
        }
    }
}
