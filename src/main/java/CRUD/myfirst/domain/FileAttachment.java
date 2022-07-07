package CRUD.myfirst.domain;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileAttachment {

    @Id
    @GeneratedValue
    private Long fid;

    // 파일 오리지널 이름
    private String uploadFileName;
    
    // 서버에 저장되는 이름
    private String storeFileName;


    private String allFileName;
    // 이후 확장자, 사이즈, 파일 패스 저장하기
    
    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public FileAttachment(Long fid,String allFileName,String uploadFileName,String storeFileName){
        this.fid=fid;
        this.allFileName=allFileName;
        this.uploadFileName=uploadFileName;
        this.storeFileName=storeFileName;
    }

}
