package com.example.facebookapp.facebookapi.repositories;

import com.example.facebookapp.facebookapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
