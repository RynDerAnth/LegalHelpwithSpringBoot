package pbo.tubes.LegalHelpwithSpringBoot.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pbo.tubes.LegalHelpwithSpringBoot.dto.PostDTO;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import pbo.tubes.LegalHelpwithSpringBoot.models.Post;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.PenggunaRepository;
import pbo.tubes.LegalHelpwithSpringBoot.repositories.PostRepository;
import pbo.tubes.LegalHelpwithSpringBoot.services.PostService;

import static pbo.tubes.LegalHelpwithSpringBoot.mapper.PostMapper.mapToPost;
import static pbo.tubes.LegalHelpwithSpringBoot.mapper.PostMapper.mapToPostDTO;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private PenggunaRepository penggunaRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PenggunaRepository penggunaRepository) {
        this.postRepository = postRepository;
        this.penggunaRepository = penggunaRepository;
    }

    @Override
    public void createPost(Long userId, PostDTO postDto) {
        Pengguna pengguna = penggunaRepository.findById(userId).get();
        Post post = mapToPost(postDto);
        post.setPenulis(pengguna);
        postRepository.save(post);
    }

    @Override
    public List<PostDTO> findAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToPostDTO(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> postByPenulis(Pengguna pengguna) {
        List<Post> posts = postRepository.findByPenulis(pengguna);
        return posts.stream().map(post -> mapToPostDTO(post)).collect(Collectors.toList());
    }

    @Override
    public List<PostDTO> findRecentPosts() {
        List<Post> posts = postRepository.findLatestPosts();
        return posts.stream().map(post -> mapToPostDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDTO findByPostId(Long id) {
        Post post = postRepository.findById(id).get();
        return mapToPostDTO(post);
    }

    @Override
    public void updatePost(PostDTO postDto) {
        Post post = mapToPost(postDto);
        postRepository.save(post);
    }

    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
    
}
