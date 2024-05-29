package practice.post.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article parent;

    private String content;

    public static Comment createComment(Article article, String content) {
        Comment comment = new Comment();
        comment.setParent(article);
        comment.setContent(content);
        article.getCommentList().add(comment);

        return comment;
    }
}
