package com.example.EventManagement.services;

import com.example.EventManagement.dto.OrderDto;
import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();

    public void createOrder(Long eventId, Long userId, Long discountId, OrderDto orderDto);
}
