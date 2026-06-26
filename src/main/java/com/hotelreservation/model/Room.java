package com.hotelreservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String roomNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType roomType;
    
    @Column(nullable = false)
    private Double pricePerNight;
    
    @Column(nullable = false)
    private Integer capacity;
    
    @Column(nullable = false)
    private Boolean available = true;
    
    private String description;
    
    private String amenities;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;
}
