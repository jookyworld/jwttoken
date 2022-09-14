package jwttoken.controller;

import jwttoken.controller.dto.MemberDto;
import jwttoken.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입 API
    @PostMapping("/join")
    public Long join(@RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }

    // 로그인 API
    @PostMapping("/login")
    public String login(@RequestBody MemberDto memberDto) {
       return memberService.login(memberDto);
    }
}