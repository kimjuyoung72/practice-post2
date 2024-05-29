package practice.post.repository;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.post.domain.Comment;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final EntityManager em;

    public Long saveComment(Comment comment) {
        em.persist(comment);
        return comment.getId();
    }

    public Comment findComment(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> findCommentByContains(String content) {
        return em.createQuery("select c from Comment c where c.content like concat('%', :content, '%')", Comment.class)
                .setParameter("content", content)
                .getResultList();
    }
    public List<Comment> findAllComment() {
        return em.createQuery("select c from Comment c", Comment.class)
                .getResultList();
    }
}
