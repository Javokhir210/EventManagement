package com.example.EventManagement.repository;

import com.example.EventManagement.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface EventRepository extends JpaRepository<Events, Long> {
    Optional<Events> findByName(String name);
    @Query("SELECT c from Events c WHERE c.name LIKE CONCAT('%', :query, '%')")
    List<Events> searchEvents(String query);
}
