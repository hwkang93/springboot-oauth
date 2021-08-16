package hwkang.oauth.login.contoller;

import hwkang.oauth.config.auth.LoginUser;
import hwkang.oauth.config.auth.dto.SessionUser;
import hwkang.oauth.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        model.addAttribute("postList", postService.findAll());

        return "index";
    }

}
