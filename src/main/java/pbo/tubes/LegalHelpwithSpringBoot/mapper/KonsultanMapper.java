package pbo.tubes.LegalHelpwithSpringBoot.mapper;

import java.util.stream.Collectors;

import pbo.tubes.LegalHelpwithSpringBoot.dto.KonsultanDTO;
import pbo.tubes.LegalHelpwithSpringBoot.dto.RegistrationDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;

public class KonsultanMapper {
    public static Konsultan mapToKonsultan(KonsultanDTO konsultan) {
        return Konsultan.builder()
                .id(konsultan.getId())
                .nama(konsultan.getNama())
                .harga(konsultan.getHarga())
                .build();
    }

    public static KonsultanDTO mapToKonsultanDTO(Konsultan konsultan) {
        return KonsultanDTO.builder()
                .id(konsultan.getId())
                .nama(konsultan.getNama())
                .harga(konsultan.getHarga())
                .klien(konsultan.getKlien().stream().map(k -> RegistrationDTO.builder().id(k.getId()).nama(k.getNama()).email(k.getEmail()).username(k.getUsername()).password(k.getPassword()).hp(k.getHp()).build()).collect(Collectors.toList()))
                .build();
    }
}
