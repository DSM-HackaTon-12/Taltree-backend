package org.example.taltree.domain.post.usecase;

import org.springframework.security.core.Authentication;

public interface DeletePostUseCase {
    void deletePost(Integer postId, Authentication authentication);
}
