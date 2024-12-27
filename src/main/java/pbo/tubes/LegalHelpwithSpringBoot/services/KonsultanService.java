package pbo.tubes.LegalHelpwithSpringBoot.services;

import java.util.List;

import pbo.tubes.LegalHelpwithSpringBoot.dto.KonsultanDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;

public interface KonsultanService {
    List<KonsultanDTO> findAllKonsultan();
    Konsultan registerKonsultan(KonsultanDTO konsultan);
    KonsultanDTO findKonsultanById(Long id);
    void updateKonsultan(KonsultanDTO konsultan);
    void deleteKonsultan(Long id);
    List<KonsultanDTO> searchKonsultan(String query);
    List<KonsultanDTO> topKonsultan();
}
