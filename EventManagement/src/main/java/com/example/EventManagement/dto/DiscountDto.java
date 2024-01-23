package com.example.EventManagement.dto;

import com.example.EventManagement.models.Orders;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscountDto {
    private Long id;
    private String type;
    private Long amount;

    private Orders orders;
}
