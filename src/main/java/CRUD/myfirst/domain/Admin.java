package CRUD.myfirst.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Admin {

    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Long id;


    private String name;


}
