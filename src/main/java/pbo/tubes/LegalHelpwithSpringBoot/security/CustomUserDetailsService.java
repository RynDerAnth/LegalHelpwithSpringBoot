package pbo.tubes.LegalHelpwithSpringBoot.security;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.PenggunaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private PenggunaRepository penggunaRepository;

    @Autowired
    public CustomUserDetailsService(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Pengguna user = penggunaRepository.findFirstByUsername(username);
        if(user != null) {
            return new User(
                    user.getEmail(),
                    user.getPassword(),
                    user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getName()))
                            .collect(Collectors.toList())
            );
        } else {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
