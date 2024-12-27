package pbo.tubes.LegalHelpwithSpringBoot.mapper;

import pbo.tubes.LegalHelpwithSpringBoot.dto.PostDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Post;

public class PostMapper {
    public static Post mapToPost(PostDTO post) {
        return Post.builder()
                .id(post.getId())
                .konten(post.getKonten())
                .createdAt(post.getCreatedAt())
                .penulis(post.getPenulis())
                .build();
    }

    public static PostDTO mapToPostDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .konten(post.getKonten())
                .createdAt(post.getCreatedAt())
                .penulis(post.getPenulis())
                .build();
    }
}
