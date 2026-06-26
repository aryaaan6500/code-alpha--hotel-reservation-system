package com.hotelreservation.repository;

import com.hotelreservation.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByCity(String city);
    List<Hotel> findByActiveTrue();
    List<Hotel> findByNameContainingIgnoreCase(String name);
}
