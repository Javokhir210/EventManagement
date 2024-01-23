package com.example.EventManagement.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdminDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String photoUrl;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
}
