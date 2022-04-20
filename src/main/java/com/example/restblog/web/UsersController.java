package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.User;
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
//    private static final Post post1 = new Post(1L, "Post 1", "Here's the first post!", null);
//    private static final Post post2 = new Post(2L, "Post 2", "Here's the second post!", null);
//    private static final Post post3 = new Post(3L, "Post 3", "Here's the third post!", null);

    @GetMapping
    private List<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
//        users.add(new User(1, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER, Arrays.asList(post1, post2)));
//        users.add(new User(2, "scottieNehPah", "scottieEVIL@gmail.com", "IHaTEU", LocalDate.now(), USER, Arrays.asList(post3)));
        return users;
    }

//    @GetMapping("{id}")
//    public User getById(@PathVariable Long id) {
////        User user = new User(id, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER, Arrays.asList(post1, post2));
//        System.out.println(user);
//        return user;
//    }

    @GetMapping("username")
    public User getByUsername(@RequestParam String username) {
        User foundUser = new User();
        System.out.println(username);
        return foundUser;
    }

    @GetMapping("email")
    public User getByEmail(@RequestParam String email) {
        User foundUser = new User();
        System.out.println(email);
        return foundUser;
    }

    @PostMapping
    private void createUser(@RequestBody User user) {
        System.out.println(user);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        System.out.printf("Update user %s by their id: %d", updateUser.getUsername(), id);
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 8) @RequestParam String newPassword) {
        System.out.printf("Update password of user with %d, with the old password of '%s', and the new password of '%s'?", id, oldPassword, newPassword);
    }

    @DeleteMapping("{id}")
    private void deleteUserById(@PathVariable Long id) {
        System.out.printf("User to be deleted %d", id);
    }
}

