package org.example.taltree.domain.user.usecase;

import org.example.taltree.domain.user.dto.request.SignupRequestDto;

public interface SignupUseCase {
    void signup (SignupRequestDto signupRequestDto);
}
