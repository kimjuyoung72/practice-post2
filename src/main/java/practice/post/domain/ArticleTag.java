package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class ArticleTag {
    @Id
    @GeneratedValue
    @Column(name = "article_tag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
