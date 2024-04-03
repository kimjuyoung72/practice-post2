package practice.post.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.post.domain.Tag;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TagRepository {
    
    private final EntityManager em;

    public void saveTag(Tag tag) {
        if (findTagByName(tag.getName()).size() == 0) {
            em.persist(tag);
        }
    }

    public List<Tag> findTagByName(String name) {
        return em.createQuery("select t from Tag t where t.name = :name", Tag.class)
                .getResultList();
    }
}
