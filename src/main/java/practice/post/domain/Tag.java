package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.ibatis.annotations.One;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    private String name;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private Tag parent;

    @OneToMany(mappedBy = "parent")
    private List<Tag> child = new ArrayList<>();
}
