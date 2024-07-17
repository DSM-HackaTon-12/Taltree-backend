package org.example.taltree.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.post.exception.IsNotEqualWriteUser;
import org.example.taltree.domain.post.model.Post;
import org.example.taltree.domain.post.repository.PostRepository;
import org.example.taltree.domain.post.usecase.DeletePostUseCase;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteServiceImpl implements DeletePostUseCase {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void deletePost(Integer postId, Authentication authentication) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                ()-> UserNotExistException.Exception
        );

        Post post = postRepository.findPostByPostIdAndWriter_id(Long.valueOf(postId),user).orElseThrow(
                () -> IsNotEqualWriteUser.NotEqualException
        );

        postRepository.delete(post);
    }
}
