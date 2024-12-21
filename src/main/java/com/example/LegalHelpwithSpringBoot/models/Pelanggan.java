package com.example.LegalHelpwithSpringBoot.models;

import java.util.ArrayList;
import java.util.Scanner;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pelanggan")
public class Pelanggan extends User implements ManajemenTransaksi {
    private ArrayList<Transaksi> listTransaksi = new ArrayList<>();
    private ArrayList<Konsultan> listKonsultan = new ArrayList<>();
    private ArrayList<Post> postingan = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double saldoAkun;

    public Pelanggan() {
        this.saldoAkun = 0;
    }
    
    public void login(String e_mail, String pw) {
        if (email == e_mail && password == pw) {
            System.out.println("Login berhasil!\n Selamat Datang " + nama + "!\n\n");
        }
    };
    public void register(String nama, String email, String password, String hp) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.hp = hp;
        System.out.println("Register berhasil!\n Selamat Datang " + nama + "!\n\n");
    }
    public void updateProfile(String nama, String hp) {
        this.nama = nama;
        this.hp = hp;
        System.out.println("Informasi telah diupdate");
    }
    
    public Transaksi bookKonsultan(Konsultan konsultan) {
        Scanner s = new Scanner(System.in);
        listKonsultan.add(konsultan);
        Transaksi t = new Transaksi(id, nama, konsultan.nama, konsultan.harga);
        listTransaksi.add(t);
        this.saldoAkun -= konsultan.harga;
        konsultan.receiveBooking(t);
        return t;
    }
    
    public Post createPost() {
        Scanner s = new Scanner(System.in);
        System.out.print("Masukkan isi post: ");
        String konten = s.next();
        System.out.print("Masukkan tanggal pembuatan post: ");
        String tanggal = s.next();
        postingan.add(new Post(id, nama, konten, tanggal));
        return new Post(id, nama, konten, tanggal);
    }
    
    public void historiTransaksi() {
        for (Transaksi t : listTransaksi) {
            System.out.println("ID transaksi: " + t.getId());
            System.out.println("Penerima: " + t.getReceiver());
            System.out.println("Jumlah: " + t.getJumlah());
        }
    }
    
    public double cekSaldo() {
        return saldoAkun;
    }
    
    public void tambahSaldo(double jumlah) {
        this.saldoAkun += jumlah;
    }
}
