package com.example.EventManagement.controller;

import com.example.EventManagement.dto.AdminDto;
import com.example.EventManagement.dto.DiscountDto;
import com.example.EventManagement.dto.EventDto;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.services.AdminService;
import com.example.EventManagement.services.DiscountService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import com.example.EventManagement.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {
    private EventService eventService;
    private AdminService adminService;
    private DiscountService discountService;

    @Autowired
    public EventController(EventService eventService, AdminService adminService, DiscountService discountService) {
        this.eventService = eventService;
        this.adminService = adminService;
        this.discountService = discountService;
    }

    @GetMapping("/events")
    public String listEvents(Model model){
        List<EventDto> eventDtoList = eventService.findAllEvents();
        model.addAttribute("event", eventDtoList);
        return "event-main";
    }

    @GetMapping("/contacts")
    public String showContacts(Model model){
        List<AdminDto> adminDtoList = adminService.findAllAdmins();
        model.addAttribute("admin", adminDtoList);
        return "contact-page";
    }

    @GetMapping("/events/{eventId}")
    public String eventDetail(@PathVariable("eventId") Long eventId, Model model){
        EventDto eventDto = eventService.findEventById(eventId);
        DiscountDto discountDto = discountService.findDiscountById(1L);
        model.addAttribute("discount", discountDto);
        model.addAttribute("event", eventDto);
        return "event-detail";
    }

    @GetMapping("/admin-events/new")
    public String createEventForm(Model model){
        Events events = new Events();
        model.addAttribute("events", events);
        return "event-create";
    }

    @PostMapping("/admin-events/new")
    public String saveEvent(@Valid @ModelAttribute("events") EventDto eventDto, BindingResult bindingResult,
                            Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("events", eventDto);
            return "event-create";
        }
        eventService.save(eventDto);
        return "redirect:/admin-events";
    }

    @GetMapping("/admin-events/{eventId}/edit")
    public String editEventForm(@PathVariable("eventId") long eventId, Model model){
        EventDto eventDto = eventService.findEventById(eventId);
        model.addAttribute("events", eventDto);
        return "event-edit";
    }

    @PostMapping("/admin-events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") long eventId,
                              @Valid @ModelAttribute("events") EventDto eventDto,
                              BindingResult result){
        if (result.hasErrors()){
            return "event-edit";
        }
        eventDto.setId(eventId);
        eventService.update(eventDto);
        return "redirect:/admin-events";
    }

    @GetMapping("/admin-events")
    public String listEventsAdmin(Model model){
        List<EventDto> eventDtoList = eventService.findAllEvents();
        model.addAttribute("event", eventDtoList);
        return "admin-events";
    }

    @GetMapping("/admin-events/{eventId}")
    public String eventDetailAdmin(@PathVariable("eventId") Long eventId, Model model){
        EventDto eventDto = eventService.findEventById(eventId);
        DiscountDto discountDto = discountService.findDiscountById(1L);
        model.addAttribute("discount", discountDto);
        model.addAttribute("event", eventDto);
        return "admin-view";
    }

    @GetMapping("/admin-events/{eventId}/delete")
    public String deleteEvent(@PathVariable("eventId") Long eventId){
        eventService.delete(eventId);
        return "redirect:/admin-events";
    }

    @GetMapping("/discounts")
    public String listDiscount(Model model){
        List<DiscountDto> discounts = discountService.findAllDiscounts();
        model.addAttribute("discount", discounts);
        return "discount-list";
    }

    @GetMapping("/discounts/{discountId}/edit")
    public String editDiscountForm(@PathVariable("discountId") long discountId, Model model){
        DiscountDto discountDto = discountService.findDiscountById(discountId);
        model.addAttribute("discount", discountDto);
        return "discount-edit";
    }

    @PostMapping("/discounts/{discountId}/edit")
    public String editDiscount(@PathVariable("discountId") long discountId, @ModelAttribute("discount") DiscountDto discountDto){
        discountService.updateDis(discountDto);
        return "redirect:/discounts";
    }
}
