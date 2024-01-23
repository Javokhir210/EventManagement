package com.example.EventManagement.repository;

import com.example.EventManagement.models.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admins, Long> {
    Optional<Admins> findByName(String name);
}
