package CRUD.myfirst.controller;

import CRUD.myfirst.domain.Book;
import CRUD.myfirst.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
// final이 붙거나 @notnull 이 붙은 필드의 생성자를 자동 생성해주는
//롬복 어노테이션
public class BookController {

    private final BookService bookService;
    
    //@ReqeustBody 와 @RequestParam 차이
    @PostMapping("/books/addbook")
    //@ResponseBody 이거 찾아보기
    // @RequestBody 도 찾아보기
    public String addingBook(BookForm bookForm, Model model){
        System.out.println("전달되었습니다.");
        return "/books/addbooks";
    }

}
