package org.example.taltree.domain.user.dto.reponse;

public record GetMypageResponseDto (
        Long userId,
        String profile,
        String username,
        String email
) {
}
