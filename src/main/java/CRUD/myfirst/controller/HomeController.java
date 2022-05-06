package CRUD.myfirst.controller;

import CRUD.myfirst.domain.Member;
import CRUD.myfirst.service.LoginService;
import CRUD.myfirst.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/join")
    public String clickjoin(Model model){
        // model 받는거랑 안받는거 차이는 ?
        model.addAttribute("memberForm",new MemberForm());

        return "/joinForm";
    }

    @PostMapping("/joinDo")
    public String join(MemberForm form){

        Member member= new Member();
        member.setName(form.getName());

        memberService.join(member);
        System.out.println(member.getName());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String clicklogin(Model model){
        model.addAttribute("loginForm",new LoginForm());

        return "/loginForm";
    }

    @PostMapping("/loginDo")
    public String login(MemberForm form){
        Boolean torf = loginService.login(form.getName());

        if(torf == true){
            return "/books";
        }else{
            return "redirect:/";
        }
    }
}
