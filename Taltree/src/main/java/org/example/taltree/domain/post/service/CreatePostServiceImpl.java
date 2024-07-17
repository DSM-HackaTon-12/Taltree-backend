package org.example.taltree.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.post.dto.request.PostRequestDTO;
import org.example.taltree.domain.post.exception.IsNullPostElement;
import org.example.taltree.domain.post.model.Post;
import org.example.taltree.domain.post.repository.PostRepository;
import org.example.taltree.domain.post.usecase.CreatePostUseCase;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreatePostServiceImpl implements CreatePostUseCase {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    @Transactional
    public void createPost(PostRequestDTO postRequestDTO, Authentication authentication) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                ()-> UserNotExistException.Exception
        );

        if (postRequestDTO == null){
            throw new IsNullPostElement();
        }



        Post post = Post.builder()
                .writer_id(user)
                .title(postRequestDTO.title())
                .content(postRequestDTO.explanation())
                .address(postRequestDTO.address())
                .contact(postRequestDTO.contact())
                .start_date(postRequestDTO.start_date())
                .end_date(postRequestDTO.end_date())
                .build();

        postRepository.save(post);
    }
}
