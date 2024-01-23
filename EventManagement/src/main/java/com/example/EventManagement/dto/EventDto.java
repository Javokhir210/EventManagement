package com.example.EventManagement.dto;

import com.example.EventManagement.models.Orders;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class EventDto {
    private Long id;
    @NotEmpty(message = "Event name cannot be empty")
    private String name;
    @NotEmpty(message = "This field cannot be empty")
    private String briefly;
    @NotEmpty(message = "Event content cannot be empty")
    private String content;
    @NotNull(message = "Event cost cannot be empty")
    private Double cost;
    @NotEmpty(message = "Event PhotoUrl cannot be empty")
    private String photoUrl;
    private LocalDateTime createdOn;

    private Orders orders;
}
