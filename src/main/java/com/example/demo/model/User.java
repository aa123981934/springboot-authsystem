package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data  // Lombok
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;  // 存 BCrypt 加密後的值

    @Column(unique = true, nullable = false)
    private String email;

    private String role = "ROLE_USER";  // 預設角色

    private String fullName;
    private String phone;
    private LocalDate birthDate;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
