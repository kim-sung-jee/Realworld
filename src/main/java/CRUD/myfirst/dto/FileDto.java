package CRUD.myfirst.dto;

import CRUD.myfirst.domain.FileAttachment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileDto {
    private Long fid;
    private String uploadFileName;
    private String storeFileName;

    public FileAttachment toEntity(){
        return FileAttachment.builder()
                .fid(fid)
                .uploadFileName(uploadFileName)
                .storeFileName(storeFileName)
                .build();
    }
    @Builder
    public FileDto(Long fid,String uploadFileName,String storeFileName){
        this.fid=fid;
        this.uploadFileName=uploadFileName;
        this.storeFileName=storeFileName;
    }
}
