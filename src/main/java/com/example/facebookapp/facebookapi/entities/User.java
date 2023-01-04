package com.example.facebookapp.facebookapi.entities;
import lombok.*;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long Id;

    @Column(nullable = false ,length = 50)
    private  String fullName;

    @Column(nullable = false ,length = 50)
    private  String email;

    @Column(nullable = false ,length = 10)
    private String gender;

    @Column(nullable = false ,length = 50)
    private String username;

    @Column(nullable = false ,length = 100)
    private  String password;

    @Temporal(TemporalType.TIMESTAMP)
    private  Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Post> userPost;

    @OneToMany(mappedBy = "user")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Comment> userComment;

}
