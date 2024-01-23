package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.DiscountDto;
import com.example.EventManagement.dto.EventDto;
import com.example.EventManagement.models.Discounts;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.repository.DiscountRepository;
import com.example.EventManagement.services.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<DiscountDto> findAllDiscounts() {
        List<Discounts> discounts = discountRepository.findAll();
        return discounts.stream().map((order1) -> mapToDiscountDto(order1)).collect(Collectors.toList());
    }

    @Override
    public DiscountDto findDiscountById(Long discountId) {
        Discounts discounts = discountRepository.findById(discountId).get();
        return mapToDiscountDto(discounts);
    }

    @Override
    public void updateDis(DiscountDto discountDto) {
        Discounts discounts = mapToDiscount(discountDto);
        discountRepository.save(discounts);
    }

    private DiscountDto mapToDiscountDto(Discounts orders) {
        DiscountDto orderDto = DiscountDto.builder()
                .id(orders.getId())
                .type(orders.getType())
                .amount(orders.getAmount())
                .build();
        return  orderDto;
    }

    private Discounts mapToDiscount(DiscountDto discountDto) {
        Discounts discounts  = Discounts.builder()
                .id(discountDto.getId())
                .type(discountDto.getType())
                .amount(discountDto.getAmount())
                .build();
        return  discounts;
    }
}
