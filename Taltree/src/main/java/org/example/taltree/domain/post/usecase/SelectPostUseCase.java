package org.example.taltree.domain.post.usecase;

import org.example.taltree.domain.post.dto.response.Response;

public interface SelectPostUseCase {
    Response findSinglePost(Integer postId);
}
