package org.example.taltree.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.GetMypageResponseDto;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.example.taltree.domain.user.usecase.GetMypageUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GetMypageServiceImpl implements GetMypageUseCase {

    private final UserRepository userRepository;

    @Override
    public GetMypageResponseDto getMypage(Authentication authentication) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                () -> UserNotExistException.Exception
        );

        return new GetMypageResponseDto(user.getUserId(), user.getProfile(), user.getUsername(), user.getEmail());
    }
}
