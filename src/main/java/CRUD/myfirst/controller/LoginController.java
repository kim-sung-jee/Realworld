package CRUD.myfirst.controller;

import CRUD.myfirst.config.SessionConst;
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
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult,
                        HttpServletRequest request, @RequestParam(defaultValue = "/") String redirectURL){
        if(bindingResult.hasErrors()){

            return "login/loginForm";
        }
        Member member = loginService.login(loginDto.getName());
        if(member==null){
            // error message
            bindingResult.reject("loginFail","아이디 또는 비밀번호 오류");
            return "login/loginForm";
        }
        // default = true인가? 아마
        HttpSession session = request.getSession();

        // 세션에 넣기. session은 아마 response에 담길듯
        session.setAttribute(SessionConst.LOGIN_MEMBER,member);




        return "redirect:"+redirectURL;
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession(false);
        if(session!=null){
            // 서버쪽 세션 저장소에서
            // invalidate 하는거임
            session.invalidate();
        }
        return "redirect:/";
    }

//    @GetMapping("/admin")
//    public String adlogin(){
//
//    }


}
