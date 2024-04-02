package practice.post.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import practice.post.domain.Member;

import java.util.List;

@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long saveMember(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member findMember(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAllMember() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
