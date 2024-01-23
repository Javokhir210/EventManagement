package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.IncomeDto;
import com.example.EventManagement.dto.OrderDto;
import com.example.EventManagement.models.Income;
import com.example.EventManagement.models.Orders;
import com.example.EventManagement.repository.IncomeRepository;
import com.example.EventManagement.repository.OrderRepository;
import com.example.EventManagement.services.IncomeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncomeServiceImpl implements IncomeService{
    private IncomeRepository incomeRepository;

    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<IncomeDto> findAllIncome() {
        List<Income> incomes = incomeRepository.findAll();
        return incomes.stream().map((order1) -> mapToIncomeDto(order1)).collect(Collectors.toList());
    }

    private IncomeDto mapToIncomeDto(Income income) {
        IncomeDto orderDto = IncomeDto.builder()
                .id(income.getId())
                .totalIncome(income.getTotalIncome())
                .build();
        return  orderDto;
    }
}
