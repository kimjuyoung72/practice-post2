package practice.post.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String content;
    private String author;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleTag> articleTagList = new ArrayList<>();
}
