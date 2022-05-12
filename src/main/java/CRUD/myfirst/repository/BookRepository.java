package CRUD.myfirst.repository;

import CRUD.myfirst.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final EntityManager em;

    public void save(Book book){
        if(book.getId()==null){
            em.persist(book);
        }else{
            // merge 는 뭘까?
            em.merge(book);
        }
    }

    public List<Book> findAll(){
        return em.createQuery("select b from Book b",Book.class).getResultList();
    }
}
