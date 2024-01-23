package com.example.EventManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "discounts")
public class Discounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Long amount;

    @OneToMany(mappedBy = "discounts", cascade = CascadeType.REMOVE)
    private Set<Orders> orders = new HashSet<>();
}
