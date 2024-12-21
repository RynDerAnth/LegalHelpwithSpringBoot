package com.example.LegalHelpwithSpringBoot.repository;

import com.example.LegalHelpwithSpringBoot.models.Konsultan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KonsultanRepository extends JpaRepository<Konsultan, Integer> {

}
