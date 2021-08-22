package hwkang.oauth.post.data;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Table(name = "posts")
@Entity
@SequenceGenerator(
        name = "POST_SEQ_GEN",      //Sequence Generator 이름
        sequenceName = "POST_SEQ",  //시퀀스 이름
        initialValue = 10,          //시퀀스 시작값 (DML 디폴트 글 건수 있어서 10부터 시작)
        allocationSize = 10         //시퀀스 범위 사이즈
        /**
            allocationSize
            시퀀스 범위 사이즈.
            메모리에 10 크기의 시퀀스 자리를 할당하고 게시글을 등록할 때마다 시퀀스를 1씩 할당함
            10 크기의 시퀀스 자리에 시퀀스가 가득 찰 경우 메모리에 추가로 10 크기의 시퀀스 자리를 할당
            예를 들어
            최초 10크가의 시퀀스 자리를 만드는데
            O O O O O O O O O O
            글을 9개 등록한 경우
            X X X X X X X X X O
            10번째 글을 등록한 경우
            X X X X X X X X X X + O O O O O O O O O O
        */
)
public class PostEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,     //사용할 전략을 시퀀스로 선택
            generator = "POST_SEQ_GEN"              //식별자 생성기를 설정해놓은 POST_SEQ_GEN 으로 설정
    )
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String registEmail;

    @Column(nullable = false)
    private LocalDateTime registDt;

    @Column
    private LocalDateTime updateDt;

    @Builder
    public PostEntity(Long id, String title, String contents, String registEmail) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.registEmail = registEmail;
    }

    public PostDto toDto() {
        return PostDto.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .registEmail(registEmail)
                .registDt(registDt)
                .updateDt(updateDt)
                .build();
    }
}
