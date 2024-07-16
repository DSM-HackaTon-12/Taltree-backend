package org.example.taltree.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserId(userId).orElseThrow();
        return new CustomUserDetail(user.getUserId());
    }
}
