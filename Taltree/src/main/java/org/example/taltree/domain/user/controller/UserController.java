package org.example.taltree.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;
import org.example.taltree.domain.user.dto.request.SignupRequestDto;
import org.example.taltree.domain.user.usecase.LoginUseCase;
import org.example.taltree.domain.user.usecase.SignupUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final LoginUseCase loginUseCase;
    private final SignupUseCase signupUseCase;

    @PostMapping("/login")
    public LoginResponseDto login (@RequestBody LoginRequestDto loginRequestDto) {
        return loginUseCase.login(loginRequestDto);
    }

    @PostMapping("/signup")
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        signupUseCase.signup(signupRequestDto);
    }
}
