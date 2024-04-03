package practice.post.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.post.domain.Article;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {

    private final EntityManager em;

    public Long saveArticle(Article article) {
        em.persist(article);
        return article.getId();
    }

    public Article findArticle(Long id) {
        return em.find(Article.class, id);
    }

    public List<Article> findAllArticle() {
        return em.createQuery("select a from Article a", Article.class)
                .getResultList();
    }
}
