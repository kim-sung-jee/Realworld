package CRUD.myfirst.repository;

import CRUD.myfirst.domain.Admin;
import CRUD.myfirst.domain.Member;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.TypeMismatchException;
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

    public Boolean login(String name){
        String query="SELECT m FROM Member m WHERE m.name = :name";
        try {
            Member member = em.createQuery(query, Member.class)
                    .setParameter("name", name).getSingleResult();
        }catch (Exception nre){
            return false;
        }
        /***
         * finally 하면 ?
         */

        return true;


    }
    public Boolean adlogin(String name){
        Admin admin= new Admin();
        admin.setName("asdf");
        em.persist(admin);


        Admin admin1 = em.find(Admin.class, 1L);
        if(admin1.getName() == name ){
            return true;
        }

        return false;
    }


}
