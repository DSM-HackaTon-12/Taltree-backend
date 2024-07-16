package org.example.taltree.domain.user.usecase;

import org.springframework.security.core.Authentication;

public interface ChangeToBasicProfileUseCase {
    void changeToBasicProfileUseCase (Authentication authentication);
}
