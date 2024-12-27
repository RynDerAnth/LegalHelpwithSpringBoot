package pbo.tubes.LegalHelpwithSpringBoot.mapper;

import pbo.tubes.LegalHelpwithSpringBoot.dto.TransaksiDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Transaksi;

public class TransaksiMapper {
    public static Transaksi mapToTransaksi(TransaksiDTO transaksi) {
        return Transaksi.builder()
                .id(transaksi.getId())
                .pengguna(transaksi.getPengguna())
                .konsultan(transaksi.getKonsultan())
                .sum(transaksi.getSum())
                .build();
    }

    public static TransaksiDTO mapToTransaksiDTO(Transaksi transaksi) {
        return TransaksiDTO.builder()
                .id(transaksi.getId())
                .pengguna(transaksi.getPengguna())
                .konsultan(transaksi.getKonsultan())
                .sum(transaksi.getSum())
                .build();
    }
}
