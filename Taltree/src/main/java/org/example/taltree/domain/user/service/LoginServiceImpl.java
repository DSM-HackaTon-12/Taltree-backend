package org.example.taltree.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.dto.reponse.LoginResponseDto;
import org.example.taltree.domain.user.dto.request.LoginRequestDto;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.example.taltree.domain.user.usecase.LoginUseCase;
import org.example.taltree.global.security.jwt.JwtProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginUseCase {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        User user = userRepository.findUserByEmail(loginRequestDto.email()).orElseThrow(
                RuntimeException::new
        );

        if(!bCryptPasswordEncoder.matches(loginRequestDto.password(), user.getPassword())) {
            throw new RuntimeException();
        };

        return new LoginResponseDto(jwtProvider.generateAccess(user.getUserId()));
    }
}
