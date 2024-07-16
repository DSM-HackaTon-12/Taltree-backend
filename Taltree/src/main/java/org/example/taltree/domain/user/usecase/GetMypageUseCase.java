package org.example.taltree.domain.user.usecase;

import org.example.taltree.domain.user.dto.reponse.GetMypageResponseDto;
import org.springframework.security.core.Authentication;

public interface GetMypageUseCase {
    public GetMypageResponseDto getMypage(Authentication authentication);
}
