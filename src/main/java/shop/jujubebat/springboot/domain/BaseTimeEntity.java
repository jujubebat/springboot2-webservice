package shop.jujubebat.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 BaseTimeEntity의 칼럼도 인식하도록 한다.
@EntityListeners(AuditingEntityListener.class) // Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity { // 모든 Entity의 상위 클래스가 되어 생성, 수정 시각을 관리하는 클래스

    @CreatedDate // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값을 변경할 떄 시간이 자동으로 저장된다.
    private LocalDateTime modifiedDate;
}
