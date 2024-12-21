package com.example.LegalHelpwithSpringBoot.models;

import java.util.ArrayList;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "admin")
public class Admin extends User {
    private ArrayList<Pelanggan> listUser = new ArrayList<>();
    private ArrayList<Konsultan> listKonsultan = new ArrayList<>();
    private ArrayList<Transaksi> listTransaksi = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    public int getId() {
		return id;
	}

	public void login(String e_mail, String pw) {
        if (email == e_mail && password == pw) {
            System.out.println("--- Login berhasil! ---\n Selamat Datang " + nama + "!\n\n");
        }
    }

    public void register(String nama, String email, String password, String hp) {
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.hp = hp;
        System.out.println("--- Register berhasil! ---\n Selamat Datang " + nama + "!\n\n");
    }
    
    public void updateProfile(String nama, String hp) {
        this.nama = nama;
        this.hp = hp;
        System.out.println("Informasi telah diupdate");
    }

    public void addPelanggan(Pelanggan pelanggan) {
        listUser.add(pelanggan);
    }
    
    public void addKonsultan(Konsultan konsul) {
        listKonsultan.add(konsul);
    }
    
    public void getListUser() {
        System.out.println("-------- Pelanggan --------");
        System.out.println("---------------------------");
        for (Pelanggan p : listUser) {
            System.out.println("Nama: " + p.nama + "\nEmail: " + p.email + "\nPassword: " + p.password + "\nNomor Telepon: " + p.hp + "\nSaldo Akun: " + p.cekSaldo());
            System.out.println("---------------------------");
        }
        System.out.println("");
        System.out.println("-------- Konsultan --------");
        System.out.println("---------------------------");
        for (Konsultan k : listKonsultan) {
            System.out.println("Nama: " + k.nama + "\nHarga: " + k.harga);
            System.out.println("---------------------------");
        }
    }
    
    public void getListTransaksi() {
        System.out.println("-------- Transaksi --------");
        System.out.println("---------------------------");
        for (Transaksi t : listTransaksi) {
            System.out.println("ID: " + t.getId() + "\nPengirim: " + t.getSender() + "\nPenerima: " + t.getReceiver() + "\nJumlah: " + t.getJumlah());
            System.out.println("---------------------------");
        }
    }
    
    public void deletePelanggan(Pelanggan user) {
        listUser.remove(user);
        System.out.println("Akun berhasil dihapus");
    }
}
