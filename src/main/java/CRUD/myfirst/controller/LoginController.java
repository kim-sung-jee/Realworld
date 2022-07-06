package CRUD.myfirst.controller;

import CRUD.myfirst.config.SessionConst;
import CRUD.myfirst.domain.Member;
import CRUD.myfirst.domain.Role;
import CRUD.myfirst.dto.LoginDto;
import CRUD.myfirst.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLSyntaxErrorException;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    // service
    private final LoginService loginService;

    @GetMapping("/login")
    // @ModelAttribute 생성 후 넘겨주
    public String doLogin(@ModelAttribute("loginDto") LoginDto loginDto, Model requestURLModel,
                          @RequestParam(defaultValue="/") String redirectURL
                          ){

        requestURLModel.addAttribute("redirectURL",redirectURL);
        return "login/loginForm";
    }
    // 관리자 로그인전용 컨트롤러?..
    @GetMapping("/admin")
    public String doAdminLogin(@ModelAttribute("loginDto") LoginDto loginDto,Model requestURLModel,
                               @RequestParam(defaultValue = "/")String redirectUrl){
        requestURLModel.addAttribute("redirectURL",redirectUrl);
        return "/login/loginForm";
    }


    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL, HttpServletRequest request){

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
        if(member.getRole()== Role.ADMIN){
            session.setAttribute(SessionConst.ADMIN_MEMBER,member);
            loginDto.setRole(Role.ADMIN);
        }else{
            session.setAttribute(SessionConst.LOGIN_MEMBER,member);
            loginDto.setRole(Role.NOMAL);
        }
        log.info("fhrmdlqselk"+redirectURL);

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



}
