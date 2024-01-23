package com.example.EventManagement.services;
import com.example.EventManagement.dto.EventDto;
import com.example.EventManagement.models.Events;

import java.util.List;

public interface EventService {
    List<EventDto> findAllEvents();

    EventDto findEventById(long eventId);

    Events save(EventDto eventDto);

    void update(EventDto eventDto);

    void delete(Long eventId);
}

