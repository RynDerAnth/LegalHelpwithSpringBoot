package pbo.tubes.LegalHelpwithSpringBoot.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;

public interface KonsultanRepository extends JpaRepository<Konsultan, Long> {
    Optional<Konsultan> findByNama(String url);
    @Query("SELECT c from Konsultan c WHERE c.nama LIKE CONCAT('%', :query, '%')")
    List<Konsultan> searchKonsultan(String query);
    @Query("SELECT c from Konsultan c ORDER BY c.harga DESC LIMIT 3")
    List<Konsultan> topKonsultan();
}
