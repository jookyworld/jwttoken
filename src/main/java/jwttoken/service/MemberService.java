package jwttoken.service;

import jwttoken.controller.dto.MemberDto;
import jwttoken.domain.Member;
import jwttoken.domain.MemberRepository;
import jwttoken.token.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;



    public Long join(MemberDto memberDto){
        Member member = Member.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))  //비밀번호 인코딩
                .roles(Collections.singletonList("ROLE_USER"))         //roles는 최초 USER로 설정
                .build();

        return memberRepository.save(member).getId();
    }

//    public String login(){
//
//    }

}
