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

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


}
