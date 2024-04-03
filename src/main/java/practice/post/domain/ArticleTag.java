package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class ArticleTag {
    @Id
    @GeneratedValue
    @Column(name = "article_tag_id")
    private Long id;

    public static ArticleTag createArticleTag(Tag tag) {
        ArticleTag articleTag = new ArticleTag();
        articleTag.setTag(tag);

        return articleTag;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}
