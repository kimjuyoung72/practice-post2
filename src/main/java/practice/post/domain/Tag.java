package practice.post.domain;

import jakarta.persistence.*;
import org.apache.ibatis.annotations.One;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "tag")
    private List<ArticleTag> articleTagList = new ArrayList<>();
}
