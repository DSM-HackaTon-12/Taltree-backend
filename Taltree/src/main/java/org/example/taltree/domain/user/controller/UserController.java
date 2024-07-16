package org.example.taltree.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.GetMypageResponseDto;
import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;
import org.example.taltree.domain.user.dto.request.SignupRequestDto;
import org.example.taltree.domain.user.dto.request.UpdateUserDataRequestDto;
import org.example.taltree.domain.user.usecase.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final LoginUseCase loginUseCase;
    private final SignupUseCase signupUseCase;
    private final GetMypageUseCase getMypageUseCase;
    private final UpdateUserDataUseCase updateUserDataUseCase;
    private final ChangeToBasicProfileUseCase changeToBasicProfileUseCase;

    @PostMapping("/login")
    public LoginResponseDto login (@RequestBody LoginRequestDto loginRequestDto) {
        return loginUseCase.login(loginRequestDto);
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup (@RequestBody SignupRequestDto signupRequestDto) {
        signupUseCase.signup(signupRequestDto);
    }

    @GetMapping("/mypage")
    public GetMypageResponseDto getMypage (Authentication authentication) {
        return getMypageUseCase.getMypage(authentication);
    }

    @PatchMapping("/update/data")
    public void updateUserData (Authentication authentication, @ModelAttribute UpdateUserDataRequestDto updateUserDataRequestDto) {
        updateUserDataUseCase.updateUserData(authentication, updateUserDataRequestDto);
    }

    @PatchMapping("/update/basic")
    public void changeToBasicProfile (Authentication authentication) {
        changeToBasicProfileUseCase.changeToBasicProfileUseCase(authentication);
    }
}
