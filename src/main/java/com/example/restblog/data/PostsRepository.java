package com.example.restblog.data;

import org.springframework.data.jpa.repository.JpaRepository;

// <entity, datatype of primary key>
public interface PostsRepository extends JpaRepository<Post, Long> {

}
