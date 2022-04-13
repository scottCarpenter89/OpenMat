package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {


    @GetMapping
    private List<Post> getAll() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 1", "Here's the first post!"));
        posts.add(new Post(2L, "Post 2", "Here is the second post!"));
        posts.add(new Post(3L, "Post 3", "Here is the third post!"));
        return posts;
    }

    @GetMapping("{postId}")
    public Post getById(@PathVariable Long postId) {
        Post post = new Post(postId, "Post Id: " + postId, "Here is the blog post you requested.");
return post;
    }
}
