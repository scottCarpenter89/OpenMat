package com.example.restblog.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// <entity, datatype of primary key>
public interface PostsRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByCategories(Category category);
}

