package com.example.restblog.web;

import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.User;
import com.example.restblog.data.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    // dependency for injection
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;



    public UsersController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, PostsRepository postsRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @GetMapping
    private List<User> getAll() {
        return usersRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return usersRepository.findById(id);
    }

    //TODO: test to see if working
    @GetMapping("me")
    public User getMyInfo(OAuth2Authentication auth) {
        String email = auth.getName();
        return usersRepository.findByEmail(email);
    }

    @GetMapping("searchByUsername")
    public User getByUsername(@RequestParam String username) {
        return usersRepository.findByUsername(username);
    }

    @GetMapping("searchByEmail")
    public User getByEmail(@RequestParam String userEmail) {
        return usersRepository.findByEmail(userEmail);
    }

    @PostMapping
    private void createUser(@RequestBody User newUser) {
        newUser.setRole(User.Role.USER);
        newUser.setCreatedAt(LocalDate.now());
        String encryptedPassword = newUser.getPassword();
        encryptedPassword = passwordEncoder.encode(encryptedPassword);
        newUser.setPassword(encryptedPassword);
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
        String oldPasswordValidator = updatePassword.getPassword();
        if (oldPasswordValidator.equals(oldPassword)) {
            // TODO: create a method that checks the user's input against parameters needed to create a strong password
            updatePassword.setPassword(newPassword);
            System.out.printf("The password for the user with the id, %d has been changed.", id);
        }
    }

    @DeleteMapping("{id}")
    private void deleteUserById(@PathVariable Long id) {
        User userToDelete = usersRepository.getById(id);
        usersRepository.delete(userToDelete);
        System.out.printf("The user with the id, %d has been deleted.", id);
    }
}

