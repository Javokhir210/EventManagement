package com.example.EventManagement.dto;

import com.example.EventManagement.models.Discounts;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.models.Users;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    @NotEmpty(message = "Location can not be empty")
    private String location;
    @NotNull(message = "Event time cannot be empty")
    @DateTimeFormat
    private LocalDateTime eventDate;
    private Double finalCost;
    private LocalDateTime orderDate;

    private Users users;
    private Discounts discounts;
    private Events events;
}
