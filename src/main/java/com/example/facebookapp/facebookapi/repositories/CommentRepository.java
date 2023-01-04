package com.example.facebookapp.facebookapi.repositories;

import com.example.facebookapp.facebookapi.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
