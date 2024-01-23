package com.example.EventManagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private LocalDateTime eventDate;
    private Double finalCost;
    @CreationTimestamp
    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "eventId", nullable = false)
    private Events events;

    @ManyToOne
    @JoinColumn(name = "discountId", nullable = false)
    private Discounts discounts;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private Users users;
}
