package org.example.taltree.domain.post.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.example.taltree.domain.user.model.User;

import java.time.LocalDateTime;

public record PostResponse(
        User writer_id,
        String title,
        String explanation,
        String address,
        String contact,
        LocalDateTime start_date,
        LocalDateTime end_date,
        String img
) {
}
