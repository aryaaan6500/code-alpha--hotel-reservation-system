package com.hotelreservation.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hotels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String country;
    
    @Column(nullable = false)
    private String phoneNumber;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private Double rating;
    
    @Column(nullable = false)
    private Integer totalRooms;
    
    private String amenities;
    
    @Column(nullable = false)
    private Boolean active = true;
}
