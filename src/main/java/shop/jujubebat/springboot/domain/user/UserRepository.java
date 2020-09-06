package shop.jujubebat.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); // email로 이미 등록된 사용자인지 확인하기 위해 사용

}
