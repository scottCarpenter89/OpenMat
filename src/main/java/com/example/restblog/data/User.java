package com.example.restblog.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    public enum Role {USER, ADMIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Email
    @NotEmpty
    private String email;


    @ToString.Exclude
    private String password;

    @Column(nullable = false)
    private LocalDate createdAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnoreProperties("author")

    @ToString.Exclude
    private Collection<Post> posts;

}
