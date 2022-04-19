package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {
private static final User user1 = new User(1L, "User 1", "user1@gmail.com", "meow", null, USER, null);
    private static final User user2 = new User(2L, "User 2", "user2@gmail.com", "ruff", null, USER, null);
    @GetMapping
    private List<Post> getAll() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 1", "Here's the first post!", user1));
        posts.add(new Post(2L, "Post 2", "Here is the second post!", user1));
        posts.add(new Post(3L, "Post 3", "Here is the third post!", user2));
        return posts;
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        Post post = new Post(id , "Post Id: " + id, "Here is the blog post you requested.", user1);
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
