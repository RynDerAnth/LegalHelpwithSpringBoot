package com.example.LegalHelpwithSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LegalHelpwithSpringBoot.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    
}

