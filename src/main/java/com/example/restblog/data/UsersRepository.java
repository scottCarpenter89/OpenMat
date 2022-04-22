package com.example.restblog.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.beans.ExceptionListener;

// <entity, datatype of primary key>
public interface UsersRepository extends JpaRepository<User, Long> {
User findByEmail(String email);
User findByUsername(String username);
User loadUserByUsername(String username);
}
