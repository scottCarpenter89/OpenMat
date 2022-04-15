package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {

    @GetMapping
    private List<Post> getAll() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 123", "Here's the first post!"));
        posts.add(new Post(2L, "Post 234", "Here is the second post!"));
        posts.add(new Post(3L, "Post 345", "Here is the third post!"));
        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        Post post = new Post(id , "Post Id: " + id, "Here is the blog post you requested.");
        return post;
    }

    @PostMapping
    private void createPost(@RequestBody Post post) {
        System.out.println(post.getId());

    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post editPost){
        System.out.printf("Backend wants us to update post id %d with %s", id, editPost);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        System.out.printf("Here is the post id to be deleted %d", id);
    }
}
