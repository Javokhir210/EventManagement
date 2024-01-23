package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.OrderDto;
import com.example.EventManagement.models.Discounts;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.models.Orders;
import com.example.EventManagement.models.Users;
import com.example.EventManagement.repository.DiscountRepository;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.repository.OrderRepository;
import com.example.EventManagement.repository.UserRepository;
import com.example.EventManagement.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private EventRepository eventRepository;
    private UserRepository userRepository;
    private DiscountRepository discountRepository;

    public OrderServiceImpl(OrderRepository orderRepository, EventRepository eventRepository,
                            UserRepository userRepository, DiscountRepository discountRepository) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.discountRepository = discountRepository;
    }

    @Override
    public void createOrder(Long eventId, Long userId, Long discountId, OrderDto orderDto) {
        Events events = eventRepository.findById(eventId).get();
        Discounts discounts = discountRepository.findById(discountId).get();
        Users users = userRepository.findById(userId).get();
        Orders orders = mapToOrder(orderDto);
        orders.setEvents(events);
        orders.setDiscounts(discounts);
        orders.setUsers(users);
        orders.setFinalCost((100-discounts.getAmount())*events.getCost()/100);
        orderRepository.save(orders);
    }

    @Override
    public List<OrderDto> findAllOrders() {
        List<Orders> orders = orderRepository.findAll();
        return orders.stream().map((order1) -> mapToOrderDto(order1)).collect(Collectors.toList());
    }


    private OrderDto mapToOrderDto(Orders orders) {
        OrderDto orderDto = OrderDto.builder()
                .id(orders.getId())
                .location(orders.getLocation())
                .eventDate(orders.getEventDate())
                .finalCost(orders.getFinalCost())
                .orderDate(orders.getOrderDate())
                .build();
        return  orderDto;
    }

    private Orders mapToOrder(OrderDto orderDto) {
        Orders orders = Orders.builder()
                .id(orderDto.getId())
                .location(orderDto.getLocation())
                .eventDate(orderDto.getEventDate())
                .finalCost(orderDto.getFinalCost())
                .orderDate(orderDto.getOrderDate())
                .build();
        return  orders;
    }
}
