package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.UsersRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {

    // for dependency injection
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    public PostsController(PostsRepository postsRepository, UsersRepository usersRepository) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }

    @GetMapping
    private List<Post> getAll() {
        return postsRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Post> getById(@PathVariable Long id) {
        return postsRepository.findById(id);
    }

    @PostMapping
    private void createPost(@RequestBody Post post) {
        post.setAuthor(usersRepository.getById(1L));
        postsRepository.save(post);
        System.out.printf("A post with the id %d was created.", post.getId());
        System.out.println();
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post editPost){
        Post postToUpdate = postsRepository.getById(id);
        postToUpdate.setTitle(editPost.getTitle());
        postToUpdate.setContent(editPost.getContent());
        postsRepository.save(postToUpdate);
        System.out.printf("Post with the id, %d was updated.", id);
        System.out.println();
    }

    @DeleteMapping("{id}")
    private void deletePost(@PathVariable Long id) {
        Post postToDelete = postsRepository.getById(id);
        postsRepository.delete(postToDelete);
        System.out.printf("The post with the id %d was deleted.", id);
        System.out.println();
    }
}
