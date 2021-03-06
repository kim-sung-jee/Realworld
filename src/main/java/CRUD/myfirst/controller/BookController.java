package CRUD.myfirst.controller;

import CRUD.myfirst.config.SessionConst;
import CRUD.myfirst.domain.Book;
import CRUD.myfirst.domain.FileAttachment;
import CRUD.myfirst.domain.Member;
import CRUD.myfirst.domain.OrderStatus;
import CRUD.myfirst.dto.FileDto;
import CRUD.myfirst.exception.AdminAddbookException;
import CRUD.myfirst.file.FileStore;
import CRUD.myfirst.service.BookService;
import CRUD.myfirst.service.file.FileUploadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
// final이 붙거나 @notnull 이 붙은 필드의 생성자를 자동 생성해주는
//롬복 어노테이션
@Slf4j
public class BookController {

    private final BookService bookService;
    private final FileUploadService fileUploadService;
    private final FileStore fileStore;

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
        //log.info(member.getRole().toString()+"gkgkgkgk");
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
    public String addingBook(BookForm bookForm) throws IOException {

        FileDto fileDto=fileStore.storeFile(bookForm.getAttachFile());



        fileUploadService.save(fileDto);

        // 엔티티에서 비즈니스 로직이나 생성자 넣는걸 뭐라고하는지 또 왜 사용하는지..

        Book book=new Book();
        book.setBookName(bookForm.getBookName());
        book.setPublicationDate(bookForm.getPublicateDate());
        book.setStatus(OrderStatus.FREE);
        //book.setAttachFile();
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



    //파라미터 경로
    @GetMapping("/book/orderBook")
    public String orderBook(){
        return "/books/orderbook";
    }
}
