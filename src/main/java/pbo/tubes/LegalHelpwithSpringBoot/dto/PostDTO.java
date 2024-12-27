package pbo.tubes.LegalHelpwithSpringBoot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long id;
    private String konten;
    private LocalDateTime createdAt;
    private Pengguna penulis;
}
