package com.example.EventManagement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IncomeDto {
    private Long id;
    private Long totalIncome;
}
