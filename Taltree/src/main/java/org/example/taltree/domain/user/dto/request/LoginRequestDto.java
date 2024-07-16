package org.example.taltree.domain.user.dto.request;

public record LoginRequestDto (
        String email,
        String password
) {
}
