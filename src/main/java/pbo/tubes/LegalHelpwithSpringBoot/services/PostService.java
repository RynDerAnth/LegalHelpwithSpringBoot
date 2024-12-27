package pbo.tubes.LegalHelpwithSpringBoot.services;

import java.util.List;

import pbo.tubes.LegalHelpwithSpringBoot.dto.PostDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;

public interface PostService {
    void createPost(Long userId, PostDTO postDto);
    List<PostDTO> findAllPosts();
    List<PostDTO> postByPenulis(Pengguna pengguna);
    List<PostDTO> findRecentPosts();
    PostDTO findByPostId(Long id);
    void updatePost(PostDTO postDto);
    void deletePost(long id);
}
