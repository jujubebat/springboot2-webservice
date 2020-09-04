package shop.jujubebat.springboot.web.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shop.jujubebat.springboot.domain.posts.Posts;
import shop.jujubebat.springboot.domain.posts.PostsRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 별다른 설정 없이 이 어노테이션을 사용할 경우 인메모리 H2 데이터 베이스를 자동으로 실행한다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정한다. 테스트용 데이터가 남아있으면 테스트가 실패할 수 있기에 테스트가 끝날 때마다 데이터를 모두 지우는 작업을 수행한다.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기_테스트(){
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // save 메소드는 db insert, update 쿼리를 실행한다. id 값이 있으면 update, 없다면 insert가 실행된다.
                .title(title)
                .content(content)
                .author("bbwwpark@naver.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll(); // 테이블의 모든 데이터를 select 한다.

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
