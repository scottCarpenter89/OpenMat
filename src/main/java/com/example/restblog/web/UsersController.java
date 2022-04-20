package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
import com.example.restblog.data.UsersRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/account", headers = "Accept=application/json")
public class UsersController {

    // dependency for injection
    private UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    //    private static final Post post1 = new Post(1L, "Post 1", "Here's the first post!", null);
//    private static final Post post2 = new Post(2L, "Post 2", "Here's the second post!", null);
//    private static final Post post3 = new Post(3L, "Post 3", "Here's the third post!", null);

    @GetMapping
    private List<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
//        users.add(new User(1, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER, Arrays.asList(post1, post2)));
//        users.add(new User(2, "scottieNehPah", "scottieEVIL@gmail.com", "IHaTEU", LocalDate.now(), USER, Arrays.asList(post3)));
        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
//        User user = new User(id, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER, Arrays.asList(post1, post2));
        System.out.printf("Found the user id requested: %d", id);
        return usersRepository.getById(id);
    }

    @GetMapping("username")
    public User getByUsername(@RequestParam String username) {
        User foundUser = new User();
        foundUser.setUsername(username);
        System.out.printf("Found the username requested: %s", username);
        return usersRepository.save(foundUser);
    }

    @GetMapping("email")
    public User getByEmail(@RequestParam String email) {
        User foundUser = new User();
        foundUser.setEmail(email);
        System.out.printf("Found the email requested: %s", email);
        return foundUser;
    }

    @PostMapping
    private void createUser(@RequestBody User user) {
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword(), user.getCreatedAt(), user.getRole());
        usersRepository.save(newUser);
        System.out.printf("A new user was created with the id of: %d", newUser.getId());
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        User userToUpdate = usersRepository.getById(id);
        userToUpdate.setUsername(updateUser.getUsername());
        userToUpdate.setEmail(updateUser.getEmail());
        userToUpdate.setPassword(updateUser.getPassword());
        userToUpdate.setCreatedAt(updateUser.getCreatedAt());
        userToUpdate.setRole(updateUser.getRole());
        usersRepository.save(userToUpdate);
        System.out.printf("The user with the id, %d was updated.", id);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 8) @RequestParam String newPassword) {

        User updatePassword = usersRepository.getById(id);
        // TODO: create a method that gets the old password and validates it that it matches what is in the database
        String oldPasswordValidator = updatePassword.getPassword();
        // TODO: create a method that checks the user's input against parameters needed to create a strong password
        updatePassword.setPassword(newPassword);
        System.out.printf("The password for the user with the id, %d has been changed.", id);
    }

    @DeleteMapping("{id}")
    private void deleteUserById(@PathVariable Long id) {
        User userToDelete = usersRepository.getById(id);
        usersRepository.delete(userToDelete);
        System.out.printf("The user with the id, %d has been deleted.", id);
    }
}

