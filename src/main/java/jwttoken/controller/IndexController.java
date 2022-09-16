package jwttoken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
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
