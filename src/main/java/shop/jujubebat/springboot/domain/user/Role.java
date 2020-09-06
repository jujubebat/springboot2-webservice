package shop.jujubebat.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { // 사용자의 권한을 관리할 Enum 클래스

    GUEST("ROLE_GUEST","손님"), // 스프링 시큐리티에서는 권한 코드에 한상 ROLE_ 이 앞에 있어야만 한다. 
    USER("ROLE_USER","일반 사용자");

    private final String key;
    private final String title;

}
