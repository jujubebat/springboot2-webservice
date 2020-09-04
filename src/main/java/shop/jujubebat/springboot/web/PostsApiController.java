package shop.jujubebat.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import shop.jujubebat.springboot.service.posts.PostsService;
import shop.jujubebat.springboot.web.dto.PostsResponseDto;
import shop.jujubebat.springboot.web.dto.PostsSaveRequestDto;
import shop.jujubebat.springboot.web.dto.PostsUpdateRequestDto;

import javax.persistence.PostUpdate;

@RequiredArgsConstructor // final 필드를 인자값으로 하는 생성자를 생성해준다. (생성자 방식으로 Bean 객체 주입)
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
