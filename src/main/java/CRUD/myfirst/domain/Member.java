package CRUD.myfirst.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue// 추가로하기
    @Column(name = "member_id") // 구분하기
    private Long id;

    private String name;


    @OneToMany(mappedBy = "member")
    private List<Order> orders= new ArrayList<>();




}
