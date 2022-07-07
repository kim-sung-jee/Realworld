package CRUD.myfirst.dto;

import CRUD.myfirst.domain.FileAttachment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FileDto {
    private String allFilename;
    private String uploadFileName;
    private String storeFileName;

    public FileAttachment toEntity(){
        return FileAttachment.builder()
                .allFileName(allFilename)
                .uploadFileName(uploadFileName)
                .storeFileName(storeFileName)
                .build();
    }
    @Builder
    public FileDto(String allFilename,String uploadFileName,String storeFileName){
        this.allFilename=allFilename;
        this.uploadFileName=uploadFileName;
        this.storeFileName=storeFileName;
    }
}
