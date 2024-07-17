package org.example.taltree.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.post.dto.request.PostRequestDTO;
import org.example.taltree.domain.post.exception.IsNotEqualWriteUser;
import org.example.taltree.domain.post.exception.NoExistPostElement;
import org.example.taltree.domain.post.model.Post;
import org.example.taltree.domain.post.repository.PostRepository;
import org.example.taltree.domain.post.usecase.UpdatePostUseCase;
import org.example.taltree.domain.user.exception.UserNotExistException;
import org.example.taltree.domain.user.model.User;
import org.example.taltree.domain.user.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateServiceImpl implements UpdatePostUseCase {

    private final PostRepository postRepository;
    private final UserRepository userRepository;





    @Override
    @Transactional
    public void updatePost(PostRequestDTO postRequestDTO, Integer postId, Authentication authentication) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                ()->UserNotExistException.Exception
        );
        Post post =postRepository.findPostByPostIdAndWriter_id(Long.valueOf(postId),user).orElseThrow(
                ()->IsNotEqualWriteUser.NotEqualException
        );

        post.setTitle(postRequestDTO.title());
        post.setContent(postRequestDTO.explanation());
        post.setAddress(postRequestDTO.address());
        post.setContact(postRequestDTO.contact());
        post.setStart_date(postRequestDTO.start_date());
        post.setEnd_date(postRequestDTO.end_date());

        postRepository.save(post);
    }



    @Override
    @Transactional
    public void applicationPost(Authentication authentication, Integer postId) {
        User user = userRepository.findUserByUserId(Long.parseLong(authentication.getName())).orElseThrow(
                ()-> UserNotExistException.Exception
        );
        Post post = postRepository.findPostByPostId(Long.valueOf(postId)).orElseThrow(
                ()->NoExistPostElement.Exception
        );
        post.setApplicant_id(user);
        postRepository.save(post);
    }
}
