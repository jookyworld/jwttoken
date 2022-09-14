package jwttoken.controller;

import jwttoken.controller.dto.MemberDto;
import jwttoken.domain.Member;
import jwttoken.domain.MemberRepository;
import jwttoken.service.MemberService;
import jwttoken.token.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    private final MemberService memberService;

//    // 회원가입 API
//    @PostMapping("/join")
//    public Long join(@RequestBody Map<String, String> user) {
//        // 넘겨받은 email, password 로 Member 객체를 만들어 save
//        return memberRepository.save(Member.builder()
//                .email(user.get("email"))
//                .password(passwordEncoder.encode(user.get("password")))    // 비밀번호는 인코딩
//                .roles(Collections.singletonList("ROLE_USER"))  // roles는 USER 로 설정
//                .build()).getId();
//    }


    // 회원가입 API
    @PostMapping("/join")
    public Long join(@RequestBody MemberDto memberDto) {
        return memberService.join(memberDto);
    }


    // 로그인 API
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        Member member = memberRepository.findByEmail(user.get("email"))
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if (!passwordEncoder.matches(user.get("password"), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        // 로그인에 성공하면 email, roles 로 토큰 생성 후 반환
        return jwtTokenProvider.createToken(member.getUsername(), member.getRoles());
    }
}