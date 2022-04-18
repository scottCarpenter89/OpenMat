package com.example.restblog.web;

import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getAll() {

        return null;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        User user = new User(id, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER);
        System.out.println(user);
        return user;
    }

    @PostMapping
    private void createUser(@RequestBody User user) {
        System.out.println(user);
    }

    @PutMapping("{id}")
    private void updateUser(@PathVariable Long id, @RequestBody User updateUser) {
        System.out.printf("Update user %s by their id: %d", updateUser.getUsername(), id);
    }

    @DeleteMapping("{id}")
    private void deleteUserById(@PathVariable Long id) {
        System.out.printf("User to be deleted %d", id);
    }
}
