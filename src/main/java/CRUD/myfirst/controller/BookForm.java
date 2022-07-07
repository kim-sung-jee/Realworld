package CRUD.myfirst.controller;


import CRUD.myfirst.dto.FileDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
public class BookForm {


    private String bookName;

    private String publicateDate;

    private List<MultipartFile> imageFile;

    private MultipartFile attachFile;



}
