package practice.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Comment;
import practice.post.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository repository;

    @Transactional
    public Long addComment(Comment comment) {
        Long savedId = repository.saveComment(comment);
        return savedId;
    }

    public List<Comment> findAllComment() {
        return repository.findAllComment();
    }
}
