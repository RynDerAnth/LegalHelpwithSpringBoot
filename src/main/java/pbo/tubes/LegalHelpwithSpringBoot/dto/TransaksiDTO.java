package pbo.tubes.LegalHelpwithSpringBoot.dto;

import lombok.Builder;
import lombok.Data;
import pbo.tubes.LegalHelpwithSpringBoot.models.Konsultan;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;

@Data
@Builder
public class TransaksiDTO {
    private Long id;
    private Pengguna pengguna;
    private Konsultan konsultan;
    private int sum;
}
