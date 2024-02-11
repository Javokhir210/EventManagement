package com.example.EventManagement.dto;

import com.example.EventManagement.models.Orders;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Surname cannot be empty")
    private String surname;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    @NotNull(message = "Age cannot be empty")
    private Integer age;
    @NotEmpty(message = "Password can't be empty")
    private String password;

    private Orders orders;
}
