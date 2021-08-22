package hwkang.oauth.post.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class PostSaveRequest {
    private String title;
    private String contents;
}
