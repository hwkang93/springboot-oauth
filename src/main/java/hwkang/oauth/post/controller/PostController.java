package hwkang.oauth.post.controller;

import hwkang.oauth.config.auth.LoginUser;
import hwkang.oauth.config.auth.dto.SessionUser;
import hwkang.oauth.post.data.PostDto;
import hwkang.oauth.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String registerView(Model model, @LoginUser SessionUser user) {

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "post";
    }

    @PostMapping
    public String register(PostDto postDto) {
        boolean saveResult = postService.save(postDto);

        return "";
    }
}
