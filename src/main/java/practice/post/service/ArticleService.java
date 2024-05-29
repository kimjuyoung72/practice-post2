package practice.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Article;
import practice.post.domain.ArticleTag;
import practice.post.domain.Tag;
import practice.post.dto.PostList;
import practice.post.repository.ArticleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository repository;

    @Transactional
    public Long register(Long memberId, String title, String content, String tagName) {

        Tag tag = Tag.createTag(tagName);
        ArticleTag articleTag = ArticleTag.createArticleTag(tag);
        Article article = Article.createArticle(memberId, title, content, articleTag);
        return article.getId();
    }

    public Article findArticle(Long id) {
        return repository.findArticle(id);
    }

    public List<PostList> findAllArticle() {
        return repository.findAllArticle();
    }
}
