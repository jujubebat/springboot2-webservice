package shop.jujubebat.springboot.web.dto;

import lombok.Getter;
import shop.jujubebat.springboot.domain.posts.Posts;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){ // 엔터티를 인자로 받아, Dto로 변환해주는 생성자.
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
