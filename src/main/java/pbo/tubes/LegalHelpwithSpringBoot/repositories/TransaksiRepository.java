package pbo.tubes.LegalHelpwithSpringBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.models.Transaksi;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    Optional<Transaksi> findById(int id);
    List<Transaksi> findByPengguna(Pengguna pengguna);
    List<Transaksi> findByKonsultan(Konsultan konsultan);
}
