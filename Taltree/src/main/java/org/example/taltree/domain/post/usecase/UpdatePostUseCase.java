package org.example.taltree.domain.post.usecase;


import org.example.taltree.domain.post.dto.request.PostRequestDTO;
import org.springframework.security.core.Authentication;

public interface UpdatePostUseCase {


    void updatePost(PostRequestDTO postRequestDTO,Integer postId, Authentication authentication);

    void applicationPost(Authentication authentication,Integer postId);
}
