package CRUD.myfirst.service;

import CRUD.myfirst.domain.Book;
import CRUD.myfirst.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void saveBook(Book book){
       bookRepository.save(book);
    }

    // 책 찾기 추가하기(하나)

    // 책 찾기 추가하기(여러개)
}
