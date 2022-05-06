package CRUD.myfirst.repository;

import CRUD.myfirst.domain.Member;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
    @PersistenceContext
    private final EntityManager em;

    public Boolean login(String name){
        String query="SELECT m FROM Member m WHERE m.name = :name";
        Member member =em.createQuery(query,Member.class)
                .setParameter("name",name).getSingleResult();
        if(member == null){
            return false;
        }else{
            return true;
        }
    }

}
