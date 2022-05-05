package CRUD.myfirst.service;


import CRUD.myfirst.domain.Member;
import CRUD.myfirst.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        // validateDuplicateMember(member)
        memberRepository.save(member);
        return member.getId();
    }

}
