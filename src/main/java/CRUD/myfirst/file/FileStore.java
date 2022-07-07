package CRUD.myfirst.file;

import CRUD.myfirst.domain.FileAttachment;
import CRUD.myfirst.dto.FileDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStore {
    @Value("${file.dir}")
    private String fileDir;

    public String getFullPath(String filename){return fileDir+filename;}


    public FileDto storeFile(MultipartFile multipartFile) throws IOException {
        if(multipartFile.isEmpty()){
            return null;
        }
        String originalFilename=multipartFile.getOriginalFilename();
        String storeFileName=createStoreFileName(originalFilename);
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        return new FileDto(originalFilename+storeFileName,originalFilename,storeFileName);
    }
    private String createStoreFileName(String originalFilename){
        String ext=extractExt(originalFilename);
        String uuid= UUID.randomUUID().toString();
        return uuid+"."+ext;
    }
    private String extractExt(String originalFilename){
        int pos=originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos+1);
    }

}
