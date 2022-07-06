package CRUD.myfirst.service.file;

import CRUD.myfirst.dto.FileDto;
import CRUD.myfirst.repository.FileRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    private final FileRepository fileRepository;

    @Transactional
    public Long save(FileDto fileDto){
        return fileRepository.save(fileDto.toEntity()).getFid();
    }
}
