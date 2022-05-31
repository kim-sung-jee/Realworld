package CRUD.myfirst.service;

import CRUD.myfirst.domain.Member;
import CRUD.myfirst.domain.Role;
import CRUD.myfirst.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    @Transactional
    public Member login(String name){
        return loginRepository.login(name);
    }

    @Transactional
    public Role checkRole(String name){
        return loginRepository.login(name).getRole();
    }

}
