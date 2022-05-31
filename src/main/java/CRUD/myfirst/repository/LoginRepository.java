package CRUD.myfirst.repository;

import CRUD.myfirst.domain.Admin;
import CRUD.myfirst.domain.Member;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.TypeMismatchException;
import org.hibernate.annotations.common.reflection.XMember;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
    @PersistenceContext
    private final EntityManager em;

    public Member login(String name){
        String query="SELECT m FROM Member m WHERE m.name = :name";
        Member member;
        try {
            member = em.createQuery(query, Member.class)
                    .setParameter("name", name).getSingleResult();
        }catch (Exception nre){
            return null;
        }
        /***
         * finally 하면 ?
         */

        return member;


    }



}
