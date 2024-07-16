package org.example.taltree.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.request.SignupRequestDto;
import org.example.taltree.domain.user.exception.EmailAlreadyExistsException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.example.taltree.domain.user.usecase.SignupUseCase;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SignupServiceImpl implements SignupUseCase {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void signup(SignupRequestDto signupRequestDto) {
        if (userRepository.findUserByEmail(signupRequestDto.email()).isPresent()) {
            throw EmailAlreadyExistsException.Exception;
        }

        User user = User.builder()
                .username(signupRequestDto.username())
                .email(signupRequestDto.email())
                .password(bCryptPasswordEncoder.encode(signupRequestDto.password()))
                .build();

        userRepository.save(user);
    }
}
