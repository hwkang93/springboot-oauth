package hwkang.post.data;

import lombok.Builder;

import java.time.LocalDateTime;

public class PostDto {

    private Long id;
    private String title;
    private String contents;
    private String registEmail;
    private LocalDateTime registDt;
    private LocalDateTime updateDt;

    @Builder
    public PostDto(Long id, String title, String contents, String registEmail,
                   LocalDateTime registDt, LocalDateTime updateDt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.registEmail = registEmail;
        this.registDt = registDt;
        this.updateDt = updateDt;
    }

    public PostEntity toEntity() {
        return PostEntity.builder()
                .id(id)
                .title(title)
                .contents(contents)
                .registEmail(registEmail)
                .build();
    }
}
