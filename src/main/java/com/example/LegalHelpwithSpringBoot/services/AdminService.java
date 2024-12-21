package com.example.LegalHelpwithSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LegalHelpwithSpringBoot.repository.AdminRepository;
import com.example.LegalHelpwithSpringBoot.models.Admin;
import com.example.LegalHelpwithSpringBoot.dto.AdminDTO;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<AdminDTO> getAllAdmin() {
        return adminRepository.findAll().stream().map(a -> new AdminDTO(a.getId(), a.getNama(), a.getEmail(), a.getHp())).toList();
    }

    public AdminDTO registerAdmin(AdminDTO admin) {
        Admin a = new Admin();
        a.setNama(admin.getNama());
        a.setEmail(admin.getEmail());
        a.setHp(admin.getHp());
        adminRepository.save(a);
        return admin;
    }

    public void updateAdmin(int id, AdminDTO admin) {
        Admin a = adminRepository.findById(id).orElseThrow();
        a.setNama(admin.getNama());
        a.setHp(admin.getHp());
        adminRepository.save(a);
    }
}
