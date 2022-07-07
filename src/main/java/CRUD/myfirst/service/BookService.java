package CRUD.myfirst.service;

import CRUD.myfirst.domain.Book;
import CRUD.myfirst.exception.AdminAddbookException;
import CRUD.myfirst.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    @Transactional
    public void saveBook(Book book){

        String bookName = book.getBookName();
        String publicationDate = book.getPublicationDate();
        if(bookName==""||publicationDate==""){
            throw new AdminAddbookException("빈칸은 허용하지 않습니다.");
        }else {
            bookRepository.save(book);
        }
    }

    // 책 찾기 추가하기(하나)

    // 책 찾기 추가하기(여러개)

    public List<Book> findBooks(){
        return bookRepository.findAll();
    }
}
