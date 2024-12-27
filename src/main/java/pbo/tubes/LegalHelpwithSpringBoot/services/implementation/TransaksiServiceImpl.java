package pbo.tubes.LegalHelpwithSpringBoot.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pbo.tubes.LegalHelpwithSpringBoot.dto.TransaksiDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.models.Transaksi;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.PenggunaRepository;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.TransaksiRepository;
import pbo.tubes.LegalHelpwithSpringBoot.security.SecurityUtil;
import pbo.tubes.LegalHelpwithSpringBoot.services.TransaksiService;

import static pbo.tubes.LegalHelpwithSpringBoot.mapper.TransaksiMapper.mapToTransaksi;
import static pbo.tubes.LegalHelpwithSpringBoot.mapper.TransaksiMapper.mapToTransaksiDTO;

@Service
public class TransaksiServiceImpl implements TransaksiService {
    private TransaksiRepository transaksiRepository;
    private PenggunaRepository penggunaRepository;
    
    public TransaksiServiceImpl(TransaksiRepository transaksiRepository,
            PenggunaRepository penggunaRepository) {
        this.transaksiRepository = transaksiRepository;
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public List<TransaksiDTO> getAllTransaksi() {
        List<Transaksi> transaksi = transaksiRepository.findAll();
        return transaksi.stream().map(t -> mapToTransaksiDTO(t)).collect(Collectors.toList());
    }

    @Override
    public TransaksiDTO getTransaksiById(int id) {
        Transaksi transaksi = transaksiRepository.findById(id).get();
        return mapToTransaksiDTO(transaksi);
    }

    @Override
    public Transaksi addTransaksi(TransaksiDTO transaksi) {
        String username = SecurityUtil.getSessionUser();
        Pengguna pengguna = penggunaRepository.findByUsername(username);
        Transaksi t = mapToTransaksi(transaksi);
        t.setPengguna(pengguna);
        return transaksiRepository.save(t);
    }

    @Override
    public List<TransaksiDTO> transaksiByPengguna(Pengguna pengguna) {
        return transaksiRepository.findByPengguna(pengguna).stream().map(t -> mapToTransaksiDTO(t)).collect(Collectors.toList());
    }

    @Override
    public List<TransaksiDTO> transaksiByKonsultan(Konsultan konsultan) {
        return transaksiRepository.findByKonsultan(konsultan).stream().map(t -> mapToTransaksiDTO(t)).collect(Collectors.toList());
    }

}
