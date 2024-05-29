package practice.post.repository;


import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.post.domain.Article;
import practice.post.domain.Member;
import practice.post.dto.PostList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PostList> findAllArticle() {
        List<Article> resultList = em.createQuery("select a from Article a", Article.class)
                .getResultList();
        List<PostList> postLists = resultList.stream().map(article -> getPostListByArticle(article))
                .collect(Collectors.toList());

        return postLists;
    }

    private PostList getPostListByArticle(Article article) {
        PostList postInfo = new PostList();
        postInfo.setUsername(String.valueOf(em.createQuery("select username from Member m where m.id = :authorId", Member.class)
                .setParameter("authorId", article.getAuthorId())
                .getSingleResult()));
        postInfo.setPostId(article.getId());
        postInfo.setTitle(article.getTitle());
        return postInfo;
    }
}
