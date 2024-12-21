package com.example.LegalHelpwithSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LegalHelpwithSpringBoot.repository.TransaksiRepository;
import com.example.LegalHelpwithSpringBoot.models.Transaksi;
import com.example.LegalHelpwithSpringBoot.dto.TransaksiDTO;
import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    private TransaksiRepository transaksiRepository;
    public List<TransaksiDTO> getAllTransaksi() {
        return transaksiRepository.findAll().stream().map(t -> new TransaksiDTO(t.getId(), t.getSender(), t.getReceiver(), t.getJumlah())).toList();
    }

    public TransaksiDTO createTrasnsaksi(TransaksiDTO transaksi) {
        Transaksi t = new Transaksi();
        t.setSender(transaksi.getSender());
        t.setReceiver(transaksi.getReceiver());
        t.setJumlah(transaksi.getJumlah());
        transaksiRepository.save(t);
        return transaksi;
    }
}
