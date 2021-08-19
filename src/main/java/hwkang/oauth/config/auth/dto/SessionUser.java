package hwkang.oauth.config.auth.dto;

import hwkang.oauth.login.data.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Entity Class 에는 직렬화 코드를 넣지 않는게 좋음.
 * 이유
 *  - 엔티티 클래스에는 언제 다른 엔티티와 관계가 형성될 지 모름.
 *  - @OneToMany , @ManyToMany 등 자식 엔티티를 가지고 있다면 직렬화 대상에 자식들까지 포함되어
 *  성능이슈, 부수 효과가 발생할 확률이 높다.
 *  그래서 직렬화 기능(Serializable)을 가진 세션 Dto를 하나 추가로 만드는 것이 더 좋은 방법이다.
 */
@Getter
@ToString
public class SessionUser implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

}
