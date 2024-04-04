package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.One;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Tag extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Tag parent;

    @OneToMany(mappedBy = "parent")
    private List<Tag> child = new ArrayList<>();

    @OneToMany(mappedBy = "tag")
    private List<ArticleTag> articleTagList = new ArrayList<>();

    public static Tag createTag(String name) {
        Tag tag = new Tag();
        tag.setName(name);
        return tag;
    }
}
