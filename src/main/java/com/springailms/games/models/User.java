package com.springailms.games.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "app_user") // <-- Change 'user' to 'app_users' or 'users' for postgres ANSI SQL compliance 
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role; // STUDENT, INSTRUCTOR, ADMIN

    private int xp;

    @Enumerated(EnumType.STRING)
    private Plan plan; // FREE, PRO, INSTRUCTOR
}
