package CRUD.myfirst.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String bookName;

    private String publicationDate;
    
    
    // 현재 빌려갔는지 안빌려갔는지
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
