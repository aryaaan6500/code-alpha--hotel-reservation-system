package com.hotelreservation.controller;

import com.hotelreservation.model.Hotel;
import com.hotelreservation.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hotels")
@CrossOrigin(origins = "*")
public class HotelController {
    
    @Autowired
    private HotelService hotelService;
    
    @PostMapping
    public ResponseEntity<ApiResponse> addHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse(true, "Hotel added successfully", savedHotel));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelService.getHotelById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse(false, "Hotel not found", null));
    }
    
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
    
    @GetMapping("/active/list")
    public ResponseEntity<List<Hotel>> getActiveHotels() {
        return ResponseEntity.ok(hotelService.getActiveHotels());
    }
    
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city) {
        return ResponseEntity.ok(hotelService.getHotelsByCity(city));
    }
    
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Hotel>> searchHotels(@PathVariable String name) {
        return ResponseEntity.ok(hotelService.searchHotelsByName(name));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody Hotel hotel) {
        try {
            Hotel updatedHotel = hotelService.updateHotel(id, hotel);
            return ResponseEntity.ok(new ApiResponse(true, "Hotel updated successfully", updatedHotel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok(new ApiResponse(true, "Hotel deleted successfully", null));
    }
    
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<ApiResponse> deactivateHotel(@PathVariable Long id) {
        hotelService.deactivateHotel(id);
        return ResponseEntity.ok(new ApiResponse(true, "Hotel deactivated successfully", null));
    }
}
