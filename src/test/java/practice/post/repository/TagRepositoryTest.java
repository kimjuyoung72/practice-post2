package practice.post.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Tag;

@SpringBootTest
@Transactional
class TagRepositoryTest {

    @Autowired
    TagRepository repository;

    @Test
    void saveAfterDuplicatedCheckTest() {
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        tag1.setName("tag");
        tag2.setName("tag");

        Long saveId1 = repository.saveTag(tag1);
        Long saveId2 = repository.saveTag(tag2);

        Assertions.assertEquals(1L, saveId2);
    }
}