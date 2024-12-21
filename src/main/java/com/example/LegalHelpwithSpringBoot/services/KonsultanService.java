package com.example.LegalHelpwithSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LegalHelpwithSpringBoot.repository.KonsultanRepository;
import com.example.LegalHelpwithSpringBoot.models.Konsultan;
import com.example.LegalHelpwithSpringBoot.dto.KonsultanDTO;
import java.util.List;

@Service
public class KonsultanService {
    @Autowired
    private KonsultanRepository konsultanRepository;

    public List<KonsultanDTO> getAllKonsultan() {
        return konsultanRepository.findAll().stream().map(k -> new KonsultanDTO(k.getId(), k.getNama(), k.getHarga())).toList();
    }

    public KonsultanDTO addKonsultan(KonsultanDTO konsultan) {
        Konsultan k = new Konsultan();
        k.setNama(konsultan.getNama());
        k.setHarga(konsultan.getHarga());
        konsultanRepository.save(k);
        return konsultan;
    }

    public void deleteKonsultan(int id) {
        konsultanRepository.deleteById(id);
    }
}
