package org.example.taltree.domain.user.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@DynamicUpdate
@DynamicInsert
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long userId;

    @Column(nullable = false, length = 50)
    String username;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, unique = true, length = 50)
    String email;

    @Column(nullable = false)
    String profile;

    protected User() {}

    @Builder
    public User (String username, String password, String email, String profile) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }
}
