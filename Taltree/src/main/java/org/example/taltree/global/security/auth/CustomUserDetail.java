package org.example.taltree.global.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@RequiredArgsConstructor
public class CustomUserDetail implements UserDetails {
    private final Long userId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return null;
    }
}
