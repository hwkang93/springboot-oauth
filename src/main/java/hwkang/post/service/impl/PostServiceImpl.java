package hwkang.post.service.impl;

import hwkang.post.data.PostDto;
import hwkang.post.data.PostEntity;
import hwkang.post.repository.PostRepository;
import hwkang.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public List<PostDto> findByRegistEmail(String registEmail) {
        List<PostEntity> resultEntityList = postRepository.findByRegistEmail(registEmail);

        return resultEntityList.stream()
                .map(PostEntity::toDto)
                .collect(Collectors.toList());
    }

    public PostDto findById(Long id) {
        Optional<PostEntity> resultEntity = postRepository.findById(id);

        return resultEntity
                .map(PostEntity::toDto)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
