package com.example.EventManagement.repository;

import com.example.EventManagement.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {
    Optional<Orders> findById(Long id);
}
