package shop.jujubebat.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.jujubebat.springboot.config.auth.LoginUser;
import shop.jujubebat.springboot.config.auth.dto.SessionUser;
import shop.jujubebat.springboot.service.posts.PostsService;
import shop.jujubebat.springboot.web.dto.PostsResponseDto;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postsService.findAllDesc()); // postsService.findAllDesc()로 가져온 결과를 "posts"란 이름으로 index.mustache에 전달한다.

        if(user != null){ // 세션에 User가 있을 때만 model에 userName으로 등록한다.
            model.addAttribute("userName",user.getName());
        }
        return "index"; // index.mustache로 매핑되어 View Resolver가 처리하게 됩니다.
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
