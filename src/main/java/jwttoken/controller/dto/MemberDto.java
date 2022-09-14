package jwttoken.controller.dto;

import com.sun.istack.NotNull;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class MemberDto {

    @NotNull
    @Size(min = 3, max = 100)
    private String email;

    @NotNull
    @Size(min = 8, max = 300)
    private String password;

}
