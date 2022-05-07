package CRUD.myfirst.service;

import CRUD.myfirst.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    @Transactional
    public boolean login(String name){
        return loginRepository.login(name);
    }

    @Transactional
    public boolean adlogin(String name){
        return loginRepository.adlogin(name);
    }

}
