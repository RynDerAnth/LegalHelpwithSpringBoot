package pbo.tubes.LegalHelpwithSpringBoot.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KonsultanDTO {
    private Long id;
    @NotEmpty
    private String nama;
    @NotEmpty
    private int harga;
    private List<RegistrationDTO> klien;
}
