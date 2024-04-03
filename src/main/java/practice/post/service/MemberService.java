package practice.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import practice.post.domain.Member;
import practice.post.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository repository;

    @Transactional
    public Long join(Member member) {
        if (repository.findByName(member.getUsername()).size() > 0) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
        return repository.saveMember(member);
    }

    public List<Member> findAllMember() {
        return repository.findAllMember();
    }

    public Member findMember(Long id) {
        return repository.findMember(id);
    }
}
