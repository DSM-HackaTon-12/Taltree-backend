package org.example.taltree.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.example.taltree.domain.user.usecase.ChangeToBasicProfileUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeToBasicProfileServiceImpl implements ChangeToBasicProfileUseCase {

    private final UserRepository userRepository;

    @Override
    public void changeToBasicProfileUseCase(Authentication authentication) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                () -> UserNotExistException.Exception
        );

        user.setProfile("https://taltree-s3.s3.ap-northeast-2.amazonaws.com/user.png");

        userRepository.save(user);
    }
}
