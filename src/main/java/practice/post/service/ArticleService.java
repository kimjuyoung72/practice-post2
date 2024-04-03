package practice.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Article;
import practice.post.repository.ArticleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository repository;

    @Transactional
    public Long register(Article article) {
        return repository.saveArticle(article);
    }

    public Article findArticle(Long id) {
        return repository.findArticle(id);
    }

    public List<Article> findAllArticle() {
        return repository.findAllArticle();
    }
}
