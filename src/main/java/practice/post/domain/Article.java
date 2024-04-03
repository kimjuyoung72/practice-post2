package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static Article createArticle(String title, String content, Member author, ArticleTag... articleTag) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setAuthor(author);
        for (ArticleTag at : articleTag) {
            article.addArticleTag(at);
        }
        return article;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member author;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleTag> articleTagList = new ArrayList<>();

//    public void addCommentList(Comment comment) {
//        this.commentList.add(comment);
//        comment.setParent(this);
//    }
    public void addArticleTag(ArticleTag articleTag) {
        this.articleTagList.add(articleTag);
        articleTag.setArticle(this);
    }
}
