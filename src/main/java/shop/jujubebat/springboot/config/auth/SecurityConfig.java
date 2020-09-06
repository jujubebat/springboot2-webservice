package shop.jujubebat.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import shop.jujubebat.springboot.domain.user.Role;

@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정을 활성화해준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점.
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 권한 관리 대상을 지정하는 옵션, URL과 HTTP 메소드 별로 관리가 가능함
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())// api 호출은 USER 권한을 가진 사람만 가능하도록 한다.
                .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL들은 인증된 사용자들에게만 허용하도록 설정
                .and()
                .logout().logoutSuccessUrl("/")// 로그아웃 성공시 "/" 주소로 이동
                .and()
                .oauth2Login().userInfoEndpoint().userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
                // 소셜 서비스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
