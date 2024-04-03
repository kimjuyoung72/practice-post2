package practice.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Tag;
import practice.post.repository.TagRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class TagService {

    private final TagRepository repository;

    public void saveTag(Tag tag) {
        repository.saveTag(tag);
    }
}
