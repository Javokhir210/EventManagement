package com.example.EventManagement.controller;

import com.example.EventManagement.dto.DiscountDto;
import com.example.EventManagement.dto.OrderDto;
import com.example.EventManagement.dto.UserDto;
import com.example.EventManagement.models.Orders;
import com.example.EventManagement.services.EventService;
import com.example.EventManagement.services.OrderService;
import com.example.EventManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.PublicKey;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class OrderController {
    private OrderService orderService;
    private UserService userService;
    private EventService eventService;

    @Autowired
    public OrderController(OrderService orderService, UserService userService, EventService eventService) {
        this.orderService = orderService;
        this.eventService = eventService;
        this.userService = userService;
    }

    @GetMapping("/orders/{eventId}/new")
    public String createOrderForm(@PathVariable("eventId") Long eventId, Model model){
        Orders orders = new Orders();
        model.addAttribute("eventId", eventId);
        model.addAttribute("orders", orders);
        return "order-create";
    }

    @PostMapping("/orders/{eventId}/new")
    public String createOrder(@PathVariable("eventId") Long eventId,
                              @ModelAttribute("orders")OrderDto orderDto, Model model, BindingResult result){
        if (result.hasErrors()){
            return "order-create";
        }
        orderService.createOrder(eventId, 4L, 1L, orderDto);
        return "redirect:/events/"+eventId;
    }

    @GetMapping("/profile")
    public String listUser(Model model){
        List<OrderDto> orderDtoList = orderService.findAllOrders();
        model.addAttribute("orders", orderDtoList);
        return "profile-list";
    }
}
