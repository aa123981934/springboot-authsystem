package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {

    @NotBlank(message = "帳號不得為空")
    @Size(min = 4, max = 20, message = "帳號長度需介於4到20字元")
    private String username;

    @NotBlank(message = "密碼不得為空")
    @Size(min = 8, message = "密碼長度至少需8位")
    private String password;

    @NotBlank(message = "Email不得為空")
    @Email(message = "Email格式不正確")
    private String email;

    private String fullName;
    private String phone;
}