package practice.post.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany(mappedBy = "author")
//    private List<Article> articleList = new ArrayList<>();
    protected Member() {

    }
}
