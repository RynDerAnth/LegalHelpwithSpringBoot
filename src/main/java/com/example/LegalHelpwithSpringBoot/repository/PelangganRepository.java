package com.example.LegalHelpwithSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.LegalHelpwithSpringBoot.models.Pelanggan;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Integer> {
    Pelanggan findByEmail(String email);
}
