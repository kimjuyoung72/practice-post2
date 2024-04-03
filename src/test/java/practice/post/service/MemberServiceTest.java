package practice.post.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Member;
import practice.post.repository.MemberRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService service;
    @Autowired MemberRepository repository;
    @Test
    void joinTest() {
        Member memberA = new Member("memberA", 30);
        Long joinId = service.join(memberA);
        Member foundMember = repository.findMember(joinId);

        Assertions.assertSame(foundMember, memberA);
    }

    @Test
    void duplicateTest() {
        Member member1 = new Member("member", 30);
        Member member2 = new Member("member", 30);

        service.join(member1);

        Assertions.assertThrows(IllegalStateException.class, () ->
                service.join(member2));
    }
}