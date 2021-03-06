package CRUD.myfirst.controller;

import CRUD.myfirst.config.SessionConst;
import CRUD.myfirst.domain.Book;
import CRUD.myfirst.domain.Member;
import CRUD.myfirst.domain.Role;
import CRUD.myfirst.service.LoginService;
import CRUD.myfirst.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;
    private final LoginService loginService;

    @GetMapping("/join")
    public String clickjoin(Model model){
        // model 받는거랑 안받는거 차이는 ?
        model.addAttribute("memberForm",new MemberForm());

        return "/joinForm"; // 뷰네임?...
    }

    @PostMapping("/joinDo")
    public String join(MemberForm form){

        Member member= new Member();
        member.setName(form.getName());

        memberService.join(member);
        System.out.println(member.getName());
        return "redirect:/";
    }

    @GetMapping("/")
    public String homeLogin(
            @SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false) Member loginMember,
            @SessionAttribute(name = SessionConst.ADMIN_MEMBER,required = false) Member loginAdmin,
            Model model
    ){
        if(loginMember==null&&loginAdmin==null){
            return "home";
        }
        // 세션 잇으면 model에 담아서 넘겨주기.
        if(loginMember==null){
            model.addAttribute("member",loginAdmin);
            model.addAttribute("role",loginAdmin.getRole());
        }else{
            model.addAttribute("member",loginMember);
            model.addAttribute("role",null );
        }


        return "/loginHome";
    }






}
