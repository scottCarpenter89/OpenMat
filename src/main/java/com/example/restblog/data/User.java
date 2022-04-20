package com.example.restblog.data;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private LocalDate createdAt;
    @Column
    private Role role;
//    private Collection<Post> posts;


    public User(String username, String email, String password, LocalDate createdAt, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.role = role;
    }

    public enum Role {USER, ADMIN}



}
