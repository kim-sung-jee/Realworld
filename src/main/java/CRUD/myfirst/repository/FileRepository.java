package CRUD.myfirst.repository;

import CRUD.myfirst.domain.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileAttachment,Long> {
}
