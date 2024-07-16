package org.example.taltree.domain.user.usecase;

import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;

public interface LoginUseCase {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
