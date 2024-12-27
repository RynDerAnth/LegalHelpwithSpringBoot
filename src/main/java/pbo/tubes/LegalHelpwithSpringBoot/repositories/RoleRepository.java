package pbo.tubes.LegalHelpwithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pbo.tubes.LegalHelpwithSpringBoot.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
