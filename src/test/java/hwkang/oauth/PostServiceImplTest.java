package hwkang.oauth;

import hwkang.oauth.login.data.Role;
import hwkang.oauth.post.data.PostDto;
import hwkang.oauth.post.service.PostService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    PostService postService;

    @Test
    void findAll() {
        List<PostDto> postDtoList = postService.findAll();
    }
}