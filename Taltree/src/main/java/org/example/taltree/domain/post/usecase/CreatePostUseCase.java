package org.example.taltree.domain.post.usecase;

import org.example.taltree.domain.post.dto.request.PostRequestDTO;
import org.springframework.security.core.Authentication;

public interface CreatePostUseCase {
    void createPost(PostRequestDTO postRequestDTO, Authentication authentication);
}
