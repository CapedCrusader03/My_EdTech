package com.kshitij.edtech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kshitij.edtech.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
