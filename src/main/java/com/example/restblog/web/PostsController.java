package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {

    // for dependency injection
    private PostsRepository postsRepository;
    public PostsController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

//    private static final User user1 = new User(1L, "User 1", "user1@gmail.com", "meow", null, USER, null);
//    private static final User user2 = new User(2L, "User 2", "user2@gmail.com", "ruff", null, USER, null);

    @GetMapping
    private List<Post> getAll() {
//        ArrayList<Post> posts = new ArrayList<>();
//        posts.add(new Post(1L, "Post 1", "Here's the first post!", user1));
//        posts.add(new Post(2L, "Post 2", "Here is the second post!", user1));
//        posts.add(new Post(3L, "Post 3", "Here is the third post!", user2));
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    public Post getById(@PathVariable Long id) {
        return postsRepository.getById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post post) {
        Post postToAdd = new Post(post.getTitle(), post.getContent());
        postsRepository.save(postToAdd);
        System.out.printf("A post with the id %d was created", postToAdd.getId());
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post editPost){
        Post postToUpdate = postsRepository.getById(id);
        postToUpdate.setTitle(editPost.getTitle());
        postToUpdate.setContent(editPost.getContent());
        postsRepository.save(postToUpdate);
        System.out.printf("Post with the id, %d was updated.", id);
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        Post postToDelete = postsRepository.getById(id);
        postsRepository.delete(postToDelete);
        System.out.printf("The post with the id %d was deleted.", id);
    }
}
