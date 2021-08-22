package hwkang.oauth.login.repository;

import hwkang.oauth.login.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //email을 통해 이미 생성된 사용자인지, 처음 가입하는 사용자인지 판단하기 위한 메소드
    Optional<UserEntity> findByEmail(String email);
}
