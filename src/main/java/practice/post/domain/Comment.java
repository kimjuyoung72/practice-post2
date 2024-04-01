package practice.post.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article parent;
    private String content;

}
