package com.example.EventManagement.services;

import com.example.EventManagement.dto.DiscountDto;
import com.example.EventManagement.dto.OrderDto;
import com.example.EventManagement.models.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiscountService{
    List<DiscountDto> findAllDiscounts();

    DiscountDto findDiscountById(Long id);

    void updateDis(DiscountDto discountDto);
}
