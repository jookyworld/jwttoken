package jwttoken.controller;

import jwttoken.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("countMember", memberService.countAllMembers());

        return "index";
    }

    @GetMapping("/index/login")
    public String login(){
        return "login";
    }

    @GetMapping("/index/join")
    public String join(){
        return "join";
    }

}
