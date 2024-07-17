package org.example.taltree.domain.post.controller;

import lombok.RequiredArgsConstructor;
import org.example.taltree.domain.post.dto.request.PostRequestDTO;
import org.example.taltree.domain.post.dto.response.Response;
import org.example.taltree.domain.post.service.SelectServiceImpl;
import org.example.taltree.domain.post.usecase.CreatePostUseCase;
import org.example.taltree.domain.post.usecase.DeletePostUseCase;
import org.example.taltree.domain.post.usecase.SelectPostUseCase;
import org.example.taltree.domain.post.usecase.UpdatePostUseCase;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final UpdatePostUseCase UpdateUseCase;
    private final CreatePostUseCase createUseCase;
    private final SelectPostUseCase SelectUseCase;
    private final DeletePostUseCase deleteUseCase;

    @PostMapping("/create")
    public void createPost(@RequestBody PostRequestDTO postRequestDTO, Authentication authentication){
        createUseCase.createPost(postRequestDTO,authentication);
    }

    @GetMapping("/{post_id}")
    public Response selectSinglePost(@PathVariable("post_id") Integer post_id){
        return SelectUseCase.findSinglePost(post_id);
    }

    @DeleteMapping("/{post_id}")
    public void deletePost(@PathVariable("post_id") Integer postId,Authentication authentication){
        deleteUseCase.deletePost(postId,authentication);
    }
    @PatchMapping("/{post_id}")
    public void updatePost(@PathVariable("post_id") Integer postId, @RequestBody PostRequestDTO postRequestDTO, Authentication authentication){
        UpdateUseCase.updatePost(postRequestDTO,postId,authentication);
    }

    @PatchMapping("/apply/{post_id}")
    public void applySet(@PathVariable("post_id") Integer pid, Authentication authentication){
        UpdateUseCase.applicationPost(authentication,pid);
    }


}
