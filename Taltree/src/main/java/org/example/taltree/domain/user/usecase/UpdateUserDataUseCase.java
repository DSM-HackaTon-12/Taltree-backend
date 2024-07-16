package org.example.taltree.domain.user.usecase;

import org.example.taltree.domain.user.dto.request.UpdateUserDataRequestDto;
import org.springframework.security.core.Authentication;

public interface UpdateUserDataUseCase {
    public void updateUserData (Authentication authentication, UpdateUserDataRequestDto updateUserDataRequestDto);
}
