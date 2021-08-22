package hwkang.oauth.login.data;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter @ToString
@NoArgsConstructor
@Table(name = "users")
@Entity
@SequenceGenerator(
        name = "USER_SEQ_GEN",      //Sequence Generator 이름
        sequenceName = "USER_SEQ",  //시퀀스 이름
        initialValue = 1,           //시퀀스 시작값
        allocationSize = 1          //시퀀스 범위 사이즈(메모리를 통해 할당)
)
public class UserEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,     //사용할 전략을 시퀀스로 선택
            generator = "USER_SEQ_GEN"              //식별자 생성기를 설정해놓은 USER_SEQ_GEN 으로 설정
    )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Builder
    public UserEntity(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public UserEntity update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
