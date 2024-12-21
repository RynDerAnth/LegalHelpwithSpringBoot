package com.example.LegalHelpwithSpringBoot.models;

public interface ManajemenTransaksi {
    public void historiTransaksi();
    public double cekSaldo();
    public void tambahSaldo(double jumlah);
}
