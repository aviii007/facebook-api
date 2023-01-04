package com.example.facebookapp.facebookapi.entities;
import lombok.*;
import javax.persistence.*;
@Entity(name="likes")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private  Long Id;
    @Column(nullable = false, length =50)
    private  Long userId;
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

}


