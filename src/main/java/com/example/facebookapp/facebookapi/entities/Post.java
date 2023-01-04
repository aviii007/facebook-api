package com.example.facebookapp.facebookapi.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="posts")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Post {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length=500, nullable = false)
    private String post;

    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "post")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Comment> commentList;

    @OneToMany(mappedBy="post")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Like> postLikes;

    @ManyToOne
    @JoinColumn(name="user_id")
    private  User user;

}
