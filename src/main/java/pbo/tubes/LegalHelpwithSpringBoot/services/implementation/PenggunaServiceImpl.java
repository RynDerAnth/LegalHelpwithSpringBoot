package pbo.tubes.LegalHelpwithSpringBoot.services.implementation;

import java.util.Arrays;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pbo.tubes.LegalHelpwithSpringBoot.dto.RegistrationDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.models.Role;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.PenggunaRepository;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.RoleRepository;
import pbo.tubes.LegalHelpwithSpringBoot.services.PenggunaService;

@Service
public class PenggunaServiceImpl implements PenggunaService {
    private PenggunaRepository penggunaRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public PenggunaServiceImpl(PenggunaRepository penggunaRepository, RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.penggunaRepository = penggunaRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public void saveUser(RegistrationDTO registrationDto) {
        Pengguna user = new Pengguna();
        user.register(registrationDto.getNama(), registrationDto.getEmail(), registrationDto.getUsername(), passwordEncoder.encode(registrationDto.getPassword()), registrationDto.getHp());
        Role role = roleRepository.findByName("USER");
        user.setRoles(Arrays.asList(role));
        penggunaRepository.save(user);
    }

    @Override
    public Pengguna findByEmail(String email) {
        return penggunaRepository.findByEmail(email);
    }

    @Override
    public Pengguna findByUsername(String username) {
        return penggunaRepository.findByUsername(username);
    }
}
