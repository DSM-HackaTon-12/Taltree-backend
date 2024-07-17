package org.example.taltree.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.post.dto.response.PostResponse;
import org.example.taltree.domain.post.dto.response.Response;
import org.example.taltree.domain.post.exception.NoExistPostElement;
import org.example.taltree.domain.post.model.Post;
import org.example.taltree.domain.post.repository.PostRepository;
import org.example.taltree.domain.post.usecase.SelectPostUseCase;
import org.example.taltree.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SelectServiceImpl implements SelectPostUseCase {

    private final PostRepository postRepository;

    @Override
    public Response findSinglePost(Integer postId) {
        Post post = postRepository.findPostByPostId(postId.longValue()).orElseThrow(
                ()-> NoExistPostElement.Exception
        );

        PostResponse postResponse = new PostResponse(post.getWriter_id()
                , post.getTitle(), post.getContent(), post.getAddress(),
                post.getContact(),post.getStart_date(),post.getEnd_date(), post.getImage_url() );
        return new Response("post",postResponse);
    }

}
