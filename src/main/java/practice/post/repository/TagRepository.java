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

    public Long saveTag(Tag tag) {
        return getSavedTagIdAfterDuplicatedCheck(tag);
    }

    private Long getSavedTagIdAfterDuplicatedCheck(Tag tag) {
        List<Tag> tags = findTagByName(tag.getName());
        if (tags.isEmpty()) {
            em.persist(tag);
            return tag.getId();
        } else {
            return tags.get(0).getId();
        }
    }

    private List<Tag> findTagByName(String name) {
        return em.createQuery("select t from Tag t where t.name = :name", Tag.class)
                .setParameter("name", name)
                .getResultList();
    }
}
