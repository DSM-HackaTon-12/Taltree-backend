package org.example.taltree.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.GetMypageResponseDto;
import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;
import org.example.taltree.domain.user.dto.request.SignupRequestDto;
import org.example.taltree.domain.user.usecase.GetMypageUseCase;
import org.example.taltree.domain.user.usecase.LoginUseCase;
import org.example.taltree.domain.user.usecase.SignupUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final LoginUseCase loginUseCase;
    private final SignupUseCase signupUseCase;
    private final GetMypageUseCase getMypageUseCase;

    @PostMapping("/login")
    public LoginResponseDto login (@RequestBody LoginRequestDto loginRequestDto) {
        return loginUseCase.login(loginRequestDto);
    }

    @PostMapping("/signup")
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        signupUseCase.signup(signupRequestDto);
    }

    @GetMapping("/mypage")
    public GetMypageResponseDto getMypage (Authentication authentication) {
        return getMypageUseCase.getMypage(authentication);
    }
}
