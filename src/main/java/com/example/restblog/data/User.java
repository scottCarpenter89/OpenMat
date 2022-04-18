package com.example.restblog.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDate createdAt;
    private Role role;

    public enum Role {USER, ADMIN}



}
