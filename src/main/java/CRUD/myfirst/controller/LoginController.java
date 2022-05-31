package CRUD.myfirst.controller;

import CRUD.myfirst.domain.Member;
import CRUD.myfirst.dto.LoginDto;
import CRUD.myfirst.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLSyntaxErrorException;

@Controller
@RequiredArgsConstructor
public class LoginController {

    // service
    private final LoginService loginService;

    @GetMapping("/login")
    public String doLogin(@ModelAttribute("loginDto") LoginDto loginDto){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){

            return "login/loginForm";
        }
        Member member = loginService.login(loginDto.getName());
        if(member==null){
            System.out.println("sadgasdagdsasdgads");
            // error mesage ?
            bindingResult.reject("loginFail","아이디 또는 비밀번호 오류");
            return "login/loginForm";
        }


        return "redirect:";
    }

}
