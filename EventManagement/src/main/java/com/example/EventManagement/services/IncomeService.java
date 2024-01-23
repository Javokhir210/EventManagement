package com.example.EventManagement.services;

import com.example.EventManagement.dto.DiscountDto;
import com.example.EventManagement.dto.IncomeDto;
import com.example.EventManagement.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IncomeService{
    List<IncomeDto> findAllIncome();
}
