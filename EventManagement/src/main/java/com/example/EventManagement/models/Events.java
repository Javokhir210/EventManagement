package com.example.EventManagement.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String briefly;
    private String content;
    private Double cost;
    private String photoUrl;
    @CreationTimestamp
    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "events", cascade = CascadeType.REMOVE)
    private Set<Orders> orders = new HashSet<>();
}
