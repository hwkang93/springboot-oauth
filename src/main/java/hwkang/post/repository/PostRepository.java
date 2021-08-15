package hwkang.post.repository;

import hwkang.post.data.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findByRegistEmail(String registEmail);

    Optional<PostEntity> findById(Long id);
}
