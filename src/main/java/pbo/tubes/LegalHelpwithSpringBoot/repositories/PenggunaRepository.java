package pbo.tubes.LegalHelpwithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;

public interface PenggunaRepository extends JpaRepository<Pengguna, Long> {
    Pengguna findByEmail(String email);
    Pengguna findByUsername(String userName);
    Pengguna findFirstByUsername(String username);
}
