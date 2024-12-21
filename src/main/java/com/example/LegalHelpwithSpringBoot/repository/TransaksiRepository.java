package com.example.LegalHelpwithSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LegalHelpwithSpringBoot.models.Transaksi;

@Repository
public interface TransaksiRepository extends JpaRepository<Transaksi, Integer> {

}
