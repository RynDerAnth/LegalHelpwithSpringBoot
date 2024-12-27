package pbo.tubes.LegalHelpwithSpringBoot.services;

import java.util.List;

import pbo.tubes.LegalHelpwithSpringBoot.dto.TransaksiDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.models.Transaksi;

public interface TransaksiService {
    List<TransaksiDTO> getAllTransaksi();
    TransaksiDTO getTransaksiById(int id);
    Transaksi addTransaksi(TransaksiDTO transaksi);
    List<TransaksiDTO> transaksiByPengguna(Pengguna pengguna);
    List<TransaksiDTO> transaksiByKonsultan(Konsultan konsultan);
}
