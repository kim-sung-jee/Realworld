package CRUD.myfirst;

import CRUD.myfirst.domain.Admin;
import CRUD.myfirst.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final AdminRepository adminRepository;

    @PostConstruct
    public void init(){
        List<Admin> optionalAdmin =adminRepository.findAll();
        if(optionalAdmin.size()!=3){
            Admin na=Admin.builder()
                    .name("관리자임")
                    .build();
            adminRepository.save(na);
        }
    }

}
