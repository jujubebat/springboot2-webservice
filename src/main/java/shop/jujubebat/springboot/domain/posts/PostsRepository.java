package shop.jujubebat.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// JpaRepository를 상속하면 기본적인 CRUD 메소드가 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> { //  JpaRepository<엔터티 클래스, PK타입>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
