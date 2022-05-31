package CRUD.myfirst.controller;

import CRUD.myfirst.config.SessionConst;
import CRUD.myfirst.domain.Book;
import CRUD.myfirst.domain.Member;
import CRUD.myfirst.domain.OrderStatus;
import CRUD.myfirst.exception.AdminAddbookException;
import CRUD.myfirst.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
// final이 붙거나 @notnull 이 붙은 필드의 생성자를 자동 생성해주는
//롬복 어노테이션
@Slf4j
public class BookController {

    private final BookService bookService;

    // 이부분 뭔일인지 블로그에 적어두기
    @ExceptionHandler(AdminAddbookException.class)
    ResponseEntity<String> handleNotBlankInAddBook(AdminAddbookException ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/books/books")
    public String bookList(Model model){
        List<Book> bookList=bookService.findBooks();
        model.addAttribute("booklist",bookList);

        return "/books/books";

    }

    @GetMapping("/books/addbooks")
    public String addbook(@SessionAttribute(name = SessionConst.ADMIN_MEMBER,required = false) Member member){
        log.info(member.getRole().toString()+"gkgkgkgk");
        if(member == null){
            return "/";
        }

        return "/books/addbooks";
    }


    //@ReqeustBody 와 @RequestParam 차이
    // 일로 post요청이 온다면!
    @PostMapping("/books/addbook")
    //@ResponseBody 이거 찾아보기
    // @RequestBody 도 찾아보기
    public String addingBook(BookForm bookForm){

        // 예외체크를 bookForm에서 받아야하니깐 여기서 처리해야 하나...?
        // 이거 뭘로 넘어오는기 보기
        // 일단 exception 클래스로 확인해보기 !
        // script도 테스트 예정
//        if(bookForm.getBookName()=="" || bookForm.getPublicateDate() ==""){
//            throw new AdminAddbookException("빈칸은 허용하지 않아요");
//        }

        // 엔티티에서 비즈니스 로직이나 생성자 넣는걸 뭐라고하는지 또 왜 사용하는지..
        Book book=new Book();
        book.setBookName(bookForm.getBookName());
        book.setPublicationDate(bookForm.getPublicateDate());
        book.setStatus(OrderStatus.FREE);

        bookService.saveBook(book);
        //다시 리턴
        return "redirect:/books/addbooks";
        
    }

    @GetMapping("/books/returnHome")
    public String returnHome(){
        // 여기서 리다이렉트 랑
        // url전달이랑 뭔차이인지 알아보기
        // baseurl 설정 알아보기
        return "redirect:/";
    }

//    @GetMapping("/booooo")
//    public ResponseEntity<Message> serverErrorMessage(){
//        Message message=Message.builder()
//                .message1("첫번째 메시지 입니다.")
//                .message2("두번째 메시지 입니다.")
//                .build();
//
//        return new ResponseEntity<>(message,HttpStatus.INTERNAL_SERVER_ERROR);
//    }


//    @PostMapping("/books/orderbook")
//    public void test1(HttpServletRequest httpServletRequest){
//        System.out.println("BookController.test1"+httpServletRequest.getMethod());
//    }


    //파라미터 경로
    @GetMapping("/book/orderBook")
    public String orderBook(){
        return "/books/orderbook";
    }
}
