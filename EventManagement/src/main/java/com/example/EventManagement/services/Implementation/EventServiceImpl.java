package com.example.EventManagement.services.Implementation;

import com.example.EventManagement.dto.EventDto;
import com.example.EventManagement.models.Events;
import com.example.EventManagement.repository.EventRepository;
import com.example.EventManagement.services.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;

//    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Events> events = eventRepository.findAll();
        return events.stream().map((events1) -> mapToEventDto(events1)).collect(Collectors.toList());
    }

    @Override
    public EventDto findEventById(long eventId) {
        Events events = eventRepository.findById(eventId).get();
        return mapToEventDto(events);
    }

    @Override
    public Events save(EventDto eventDto) {
        Events events = mapToEvent(eventDto);
        return eventRepository.save(events);
    }

    @Override
    public void update(EventDto eventDto) {
        Events events = mapToEvent(eventDto);
        eventRepository.save(events);
    }

    @Override
    public void delete(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    private Events mapToEvent(EventDto eventDto){
        Events events = Events.builder()
                .id(eventDto.getId())
                .name(eventDto.getName())
                .briefly(eventDto.getBriefly())
                .content(eventDto.getContent())
                .cost(eventDto.getCost())
                .createdOn(eventDto.getCreatedOn())
                .photoUrl(eventDto.getPhotoUrl())
                .build();
        return events;
    }

    private EventDto mapToEventDto(Events events){
        EventDto eventDto = EventDto.builder()
                .id(events.getId())
                .briefly(events.getBriefly())
                .content(events.getContent())
                .name(events.getName())
                .cost(events.getCost())
                .createdOn(events.getCreatedOn())
                .photoUrl(events.getPhotoUrl())
                .build();
        return  eventDto;
    }
}
