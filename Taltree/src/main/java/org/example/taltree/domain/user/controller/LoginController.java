package org.example.taltree.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;
import org.example.taltree.domain.user.usecase.LoginUseCase;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final LoginUseCase loginService;

    @PostMapping("/login")
    public LoginResponseDto login (@RequestBody LoginRequestDto loginRequestDto){
        return loginService.login(loginRequestDto);
    }
}
