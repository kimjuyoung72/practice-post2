package practice.post.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Autowired
    EntityManager em;

    @Test
    void testMember() {
        Member member = new Member("memberA", 30);
        Long savedId = repository.saveMember(member);
        Member foundMember = repository.findMember(savedId);

        Assertions.assertSame(foundMember, member);
    }

    @Test
    void testPaging() {
        for (int i = 0; i < 20; i++) {
            Member member = new Member("member" + i, i);
            repository.saveMember(member);
        }
        List<Member> memberList = em.createQuery("select m from Member m order by id desc", Member.class)
                .setFirstResult(0)
                .setMaxResults(10)
                .getResultList();
        for (Member member : memberList) {
            System.out.println("username = " + member.getUsername() + ", member id = " + member.getId());
        }
        Member member = repository.findMember(1L);
        System.out.println("create at :: " + member.getCreatedAt());
        Assertions.assertEquals(10, memberList.size());
    }

}