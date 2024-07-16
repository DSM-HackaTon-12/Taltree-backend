package org.example.taltree.domain.user.dto.request;

import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public record UpdateUserDataRequestDto (
        Optional<String> username,

        Optional<MultipartFile> userProfile
) {
}
