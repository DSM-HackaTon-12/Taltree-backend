package org.example.taltree.domain.user.dto.request;

public record SignupRequestDto (
        String username,
        String password,
        String email
) {
}
