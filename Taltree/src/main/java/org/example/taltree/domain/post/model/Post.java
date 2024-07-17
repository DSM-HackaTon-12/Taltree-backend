package org.example.taltree.domain.post.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.example.taltree.domain.user.model.User;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Data
@DynamicInsert
@DynamicUpdate
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postId;

    @ManyToOne
    User writer_id;

    @ManyToOne
    User applicant_id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String content;

    @Column(nullable = false, length = 100)
    String address;

    @Column(nullable = false, length = 50)
    String contact;

    @Column(nullable = false)
    LocalDateTime start_date;

    @Column(nullable = false)
    LocalDateTime end_date;

    @Column(nullable = false)
    String image_url;

    @Builder
    public Post (String title, String content, String address,String contact,LocalDateTime start_date,LocalDateTime end_date,User writer_id,User applicant_id){
        this.title = title;
        this.content = content;
        this.address = address;
        this.contact = contact;
        this.start_date = start_date;
        this.end_date = end_date;
        this.writer_id = writer_id;
        this.applicant_id = applicant_id;
    }

    public Post() {

    }
}
