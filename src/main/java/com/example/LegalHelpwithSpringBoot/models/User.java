package com.example.LegalHelpwithSpringBoot.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    @Column(name = "nama")
    protected String nama;
    @Column(name = "email")
    protected String email;
    @Column(name = "password")
    protected String password;
    @Column(name = "hp")
    protected String hp;

    public abstract void login(String email, String password);
    public abstract void register(String nama, String email, String password, String hp);
    public abstract void updateProfile(String nama, String hp);
}

