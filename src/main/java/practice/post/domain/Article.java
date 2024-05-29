package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Article extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String content;

    private Long authorId;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleTag> articleTagList = new ArrayList<>();

    public static Article createArticle(Long authorId, String title, String content, ArticleTag articleTag) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthorId(authorId);
        article.addArticleTag(articleTag);

        return article;
    }
    public void addArticleTag(ArticleTag articleTag) {
        this.articleTagList.add(articleTag);
        articleTag.setArticle(this);
    }
}
