package hwkang.oauth.login.repository;

import hwkang.oauth.login.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //email을 통해 이미 생성된 사용자인지, 처음 가입하는 사용자인지 판단하기 위한 메소드
    Optional<User> findByEmail(String email);
}
