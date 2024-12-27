package pbo.tubes.LegalHelpwithSpringBoot.services;

import pbo.tubes.LegalHelpwithSpringBoot.dto.RegistrationDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;

public interface PenggunaService {
    void saveUser(RegistrationDTO registrationDto);
    Pengguna findByEmail(String email);
    Pengguna findByUsername(String username);
}
