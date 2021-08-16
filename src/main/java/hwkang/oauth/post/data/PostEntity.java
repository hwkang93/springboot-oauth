package hwkang.oauth.post.data;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@NoArgsConstructor
public class PostEntity {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
