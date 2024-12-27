package pbo.tubes.LegalHelpwithSpringBoot.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class Pengguna extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "booked_consultants",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "consultant_id", referencedColumnName = "id")}
    )
    private List<Konsultan> consultants = new ArrayList<>(); // Change this to a list of Konsultan

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private List<Role> roles = new ArrayList<>();

    @Override
    public void register(String nama, String email, String username, String password, String hp) {
        this.nama = nama;
        this.email = email;
        this.username = username;
        this.password = password;
        this.hp = hp;
    }

    @Override
    public void updateProfile(String nama, String hp) {
        this.nama = nama;
        this.hp = hp;
    }
}