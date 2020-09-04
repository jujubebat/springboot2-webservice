package shop.jujubebat.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.jujubebat.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 생성. Entity 클래스는 Setter을 절대 만들지 않는다. 필드 값 변경이 필요한 경우. 목적과 의도를 나타낼 수 있는 메소드를 추가하여 사용.
@NoArgsConstructor // 기본 생성자 자동추가
@Entity
public class Posts extends BaseTimeEntity { // DB 테이블과 매칭될 클래스. 엔터티 클래스라고 칭한다. 클래스 이름의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 만들어준다.

    @Id // 테이블의 Primary Key(기본키)를 나타낸다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다. IDENTITY는 auto_increment를 칭한다.
    private Long id;

    // @Column은 테이블의 컬럼(속성)을 나타낸다. 굳이 넣어주지 않아도 모든 필드는 컬럼이 된다.
    // 컬럼에 대한 추가 설정이 있을경우 사용한다. String의 경우 VARCHAR(255)가 기본인데, 크기를 500으로 변경한다.
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false) // 디폴트 VARCHAR(255) 타입을 TEXT로 변경한다.
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성. 생성자와 같은 역할을 함. 다만 빌더를 사용하면 필드명을 명확히 지정하면서, 인스턴스를 생성할 수 있음.
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
