package hwkang.oauth.post.service.impl;

import hwkang.oauth.post.data.PostDto;
import hwkang.oauth.post.data.PostEntity;
import hwkang.oauth.post.repository.PostRepository;
import hwkang.oauth.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostDto> findAll() {

        return postRepository.findAll().stream()
                .map(PostEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByRegistEmail(String registEmail) {
        List<PostEntity> resultEntityList = postRepository.findByRegistEmail(registEmail);

        return resultEntityList.stream()
                .map(PostEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) {
        Optional<PostEntity> resultEntity = postRepository.findById(id);

        return resultEntity
                .map(PostEntity::toDto)
                .orElse(new PostDto());
    }

    @Override
    public boolean save(PostDto postDto) {
        PostEntity savedEntity = postRepository.save(postDto.toEntity());

        return savedEntity != null;
    }
}
