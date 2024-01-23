package com.example.EventManagement.repository;

import com.example.EventManagement.models.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discounts, Long> {
    Optional<Discounts> findById(Long aLong);
}
