package org.example.taltree.domain.post.repository;

import org.example.taltree.domain.post.model.Post;
import org.example.taltree.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.parameters.P;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post,Long> {
    Optional<Post> findPostByPostId(Long post_id);
    Optional<Post> findPostByPostIdAndWriter_id(Long post_id, User user);
}
