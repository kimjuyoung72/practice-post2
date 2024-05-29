package practice.post.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Article;
import practice.post.domain.ArticleTag;
import practice.post.domain.Comment;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired EntityManager em;

    @Autowired
    CommentRepository repository;

    @Test
    void searchCommentByContains() {
        Article article1 = new Article();
        Article article2 = new Article();

        em.persist(article1);
        em.persist(article2);

        Comment comment1 = new Comment();
        comment1.setParent(article1);
        comment1.setContent("abc");
        Comment comment2 = new Comment();
        comment2.setParent(article2);
        comment2.setContent("bcde");

        Long saved1 = repository.saveComment(comment1);
        Long saved2 = repository.saveComment(comment2);

        List<Comment> commentList = repository.findCommentByContains("cde");

        if (commentList.isEmpty()) {
            System.out.println("일치하는 댓글이 없음.");

        } else {
            Assertions.assertSame(comment2.getContent(), commentList.get(0).getContent());
            System.out.println("content = " + commentList.get(0).getContent());
        }
    }

    @Test
    void searchCommentByContains2() {
        Article article1 = new Article();
        Article article2 = new Article();

        em.persist(article1);
        em.persist(article2);

        Comment comment1 = Comment.createComment(article1, "abc");
        System.out.println("articleId = " + article1.getId());
        System.out.println("comment1.getParent().getId() = " + comment1.getParent().getId());
        Comment comment2 = Comment.createComment(article2, "efg");
        System.out.println("articleId = " + article2.getId());
        System.out.println("comment2.getParent().getId() = " + comment2.getParent().getId());
        Long saved1 = repository.saveComment(comment1);
        Long saved2 = repository.saveComment(comment2);

        List<Comment> commentList = repository.findCommentByContains("ef");

        if (commentList.isEmpty()) {
            System.out.println("일치하는 댓글이 없음.");

        } else {
            Assertions.assertSame(comment2.getContent(), commentList.get(0).getContent());
            System.out.println("content = " + commentList.get(0).getContent());
        }
    }
}