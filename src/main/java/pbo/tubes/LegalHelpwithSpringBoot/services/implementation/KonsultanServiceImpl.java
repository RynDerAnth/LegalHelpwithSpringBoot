package pbo.tubes.LegalHelpwithSpringBoot.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pbo.tubes.LegalHelpwithSpringBoot.dto.KonsultanDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.KonsultanRepository;
import pbo.tubes.LegalHelpwithSpringBoot.security.SecurityUtil;
import pbo.tubes.LegalHelpwithSpringBoot.services.KonsultanService;

import static pbo.tubes.LegalHelpwithSpringBoot.mapper.KonsultanMapper.mapToKonsultan;
import static pbo.tubes.LegalHelpwithSpringBoot.mapper.KonsultanMapper.mapToKonsultanDTO;

@Service
public class KonsultanServiceImpl implements KonsultanService {
    private KonsultanRepository konsultanRepository;

    @Autowired
    public KonsultanServiceImpl(KonsultanRepository konsultanRepository) {
        this.konsultanRepository = konsultanRepository;
    }

    @Override
    public List<KonsultanDTO> findAllKonsultan() {
        List<Konsultan> konsultan = konsultanRepository.findAll();
        return konsultan.stream().map(k -> mapToKonsultanDTO(k)).collect(Collectors.toList());
    }

    @Override
    public Konsultan registerKonsultan(KonsultanDTO konsultanDto) {
        Konsultan konsultan = mapToKonsultan(konsultanDto);
        return konsultanRepository.save(konsultan);
    }

    @Override
    public KonsultanDTO findKonsultanById(Long id) {
        Konsultan konsultan = konsultanRepository.findById(id).get();
        return mapToKonsultanDTO(konsultan);
    }

    @Override
    public void updateKonsultan(KonsultanDTO konsultanDto) {
        Konsultan konsultan = mapToKonsultan(konsultanDto);
        konsultanRepository.save(konsultan);
    }

    @Override
    public void deleteKonsultan(Long id) {
        konsultanRepository.deleteById(id);
    }

    @Override
    public List<KonsultanDTO> searchKonsultan(String query) {
        List<Konsultan> konsultan = konsultanRepository.searchKonsultan(query);
        return konsultan.stream().map(k -> mapToKonsultanDTO(k)).collect(Collectors.toList());
    }

    @Override
    public List<KonsultanDTO> topKonsultan() {
        List<Konsultan> konsultan = konsultanRepository.topKonsultan();
        return konsultan.stream().map(k -> mapToKonsultanDTO(k)).collect(Collectors.toList());
    }
    
}
