package com.example.restblog.web;

import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/account", headers = "Accept=application/json")
public class UsersController {

    @GetMapping
    private List<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER));
        users.add(new User(2, "scottieNehPah", "scottieEVIL@gmail.com", "IHaTEU", LocalDate.now(), USER));
        return users;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        User user = new User(id, "scottieDon't", "carpenter.scott@rocketmail.com", "butterSc0Tch", LocalDate.now(), USER);
        User user2 = new User(id, "scottieNehPah", "scottieEVIL@gmail.com", "IHaTEU", LocalDate.now(), USER);
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

    @GetMapping("{username}")
    public User getByUsername(@RequestParam String username) {
        User foundUser = new User();
        System.out.println(username);
        return foundUser;
    }

    @GetMapping("{id}/email")
    public User getByEmail(@RequestParam String email) {
        User foundUser = new User();
        System.out.println(email);
        return foundUser;
    }

    @PutMapping("{id}/updatePassword")
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 8) @RequestParam String newPassword) {
        System.out.printf("Update password of user with %d, with the old password of '%s', and the new password of '%s'?", id, oldPassword, newPassword);
    }
}

