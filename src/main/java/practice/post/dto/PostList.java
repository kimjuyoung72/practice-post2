package practice.post.dto;

import lombok.Data;
import lombok.Setter;

@Data
public class PostList {
    private String username;
    private Long postId;
    private String title;
}
