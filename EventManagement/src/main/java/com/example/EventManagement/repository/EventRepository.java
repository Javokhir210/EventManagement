package com.example.EventManagement.repository;

import com.example.EventManagement.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EventRepository extends JpaRepository<Events, Long> {
    Optional<Events> findByName(String name);
}
