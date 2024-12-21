package com.example.LegalHelpwithSpringBoot.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LegalHelpwithSpringBoot.repository.PelangganRepository;
import com.example.LegalHelpwithSpringBoot.models.Pelanggan;
import com.example.LegalHelpwithSpringBoot.dto.PelangganDTO;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;
    
    public List<PelangganDTO> getAllPelanggan() {
        return pelangganRepository.findAll().stream().map(p -> new PelangganDTO(p.getId(), p.getNama(), p.getEmail(), p.getHp(), p.getSaldoAkun())).toList();
    }

    public Optional<PelangganDTO> getPelangganById(int id) {
        return pelangganRepository.findById(id).map(p -> new PelangganDTO(p.getId(), p.getNama(), p.getEmail(), p.getHp(), p.getSaldoAkun()));
    }

    public PelangganDTO registerPelanggan(PelangganDTO pelanggan) {
        Pelanggan p = new Pelanggan();
        p.setNama(pelanggan.getNama());
        p.setEmail(pelanggan.getEmail());
        p.setHp(pelanggan.getHp());
        p.setSaldoAkun(0);
        pelangganRepository.save(p);
        return pelanggan;
    }
    
    public void updatePelanggan(int id, PelangganDTO pelanggan) {
        Pelanggan p = pelangganRepository.findById(id).orElseThrow();
        p.setNama(pelanggan.getNama());
        p.setHp(pelanggan.getHp());
        pelangganRepository.save(p);
    }
    
    public void deletePelanggan(int id) {
        pelangganRepository.deleteById(id);
    }
}
