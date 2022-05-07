package CRUD.myfirst.repository;

import CRUD.myfirst.domain.Admin;
import CRUD.myfirst.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    @PersistenceContext
    private final EntityManager em;


    public void save(Member member){
        em.persist(member);
    }

    public void adminsave(Admin admin){
        em.persist(admin);
    }

}
