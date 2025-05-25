package com.coursera.entity;

import com.coursera.util.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String user_name;

    @Column(length = 100)
    private String full_name;

    @Column(nullable = false, unique = true)
    private String email;

    private String hashed_password;

    private UserRole user_role;

    @Temporal(TemporalType.TIMESTAMP)
    private final LocalTime created_at = LocalTime.now();

    public User(String user_name, String full_name, String email, String hashed_password, UserRole user_role) {
        this.user_name = user_name;
        this.full_name = full_name;
        this.email = email;
        this.hashed_password = hashed_password;
        this.user_role = user_role;
    }
}
