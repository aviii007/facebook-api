package com.example.facebookapp.facebookapi.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name="comments")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Long id;

    //@Column(nullable = false, length = 50)
    //private Long userId;

    //@Column(nullable = false, length = 50)
    //private Long postId;

    @Column(nullable = false, length = 200)
    private  String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;



}
