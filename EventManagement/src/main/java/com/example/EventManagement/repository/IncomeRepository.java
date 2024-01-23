package com.example.EventManagement.repository;

import com.example.EventManagement.models.Income;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    Optional findById(Long id);
}
