package com.meiit.webalk.GPNWZT.repositories;

import com.meiit.webalk.GPNWZT.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
