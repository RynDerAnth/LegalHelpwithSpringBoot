package pbo.tubes.LegalHelpwithSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pbo.tubes.LegalHelpwithSpringBoot.models.Post;
import pbo.tubes.LegalHelpwithSpringBoot.models.Pengguna;
import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPenulis(Pengguna penulis);
}
