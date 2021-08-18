package hwkang.oauth.post.service;

import hwkang.oauth.post.data.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> findAll();

    List<PostDto> findByRegistEmail(String registEmail);

    PostDto findById(Long id);

    boolean save(PostDto postDto);
}
