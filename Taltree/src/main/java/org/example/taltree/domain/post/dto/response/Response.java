package org.example.taltree.domain.post.dto.response;

import lombok.Builder;

import java.util.Objects;
import java.util.Optional;

@Builder
public record Response (
        String name,
        Object object
) {
}
