package com.example.facebookapp.facebookapi.repositories;

import com.example.facebookapp.facebookapi.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Like save(Like like);

    void deleteById(Long id);
}
