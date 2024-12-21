package com.example.LegalHelpwithSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.LegalHelpwithSpringBoot.repository.PostRepository;
import com.example.LegalHelpwithSpringBoot.dto.PostDTO;
import com.example.LegalHelpwithSpringBoot.models.Post;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<PostDTO> getAllPost() {
        return postRepository.findAll().stream().map(p -> new PostDTO(p.getId(), p.getPenulis(), p.getKonten(), p.getTanggal())).toList();
    }

    public PostDTO createPost(PostDTO post) {
        Post p = new Post();
        p.setPenulis(post.getPenulis());
        p.setKonten(post.getKonten());
        p.setTanggal(post.getTanggal());
        postRepository.save(p);
        return post;
    }

    public void deletePost(int id) {
        postRepository.deleteById(id);
    }
}
