package com.example.restblog.web;

import com.example.restblog.data.*;
import com.example.restblog.services.EmailService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json ")
public class PostsController {

    // for dependency injection
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;
    private final CategoriesRepository categoriesRepository;
    private final EmailService emailService;

    public PostsController(PostsRepository postsRepository, UsersRepository usersRepository, CategoriesRepository categoriesRepository, EmailService emailService) {
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.categoriesRepository = categoriesRepository;
        this.emailService = emailService;
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
    private void createPost(@RequestBody Post newPost, OAuth2Authentication auth) {
        String email = auth.getName();
        User author = usersRepository.findByEmail(email);
        newPost.setAuthor(author);
//        newPost.setAuthor(usersRepository.getById(1L));
//        List<Category> categories = new ArrayList<>();
//        categories.add(categoriesRepository.findCategoriesByName("bjj"));
//        categories.add(categoriesRepository.findCategoriesByName("golf"));
//        newPost.setCategories(categories);
        postsRepository.save(newPost);
//        System.out.printf("A post with the id %d was created.", newPost.getId());
//        System.out.println();

        emailService.prepareAndSend(newPost, "A new Post has been submitted", "See subject");

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

    @GetMapping("searchByCategory")
    private List<Post> searchPostsByCategory(@RequestParam String category) {
        return postsRepository.findAllByCategories(categoriesRepository.findCategoriesByName(category));
    }

    @GetMapping("searchByTitle")
    private List<Post> searchPostsByTitleKeyword(@RequestParam String keyword) {
        return postsRepository.searchByTitleLike(keyword);
    }
}
