package org.example.taltree.domain.user.repository;

import org.example.taltree.domain.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUserId(Long UserId);

    Optional<User> findUserByEmail(String email);
}
