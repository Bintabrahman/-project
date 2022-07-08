package com.example.Foodmanagement_system.repository;

import com.example.Foodmanagement_system.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
