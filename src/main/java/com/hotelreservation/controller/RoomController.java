package com.hotelreservation.controller;

import com.hotelreservation.model.Room;
import com.hotelreservation.model.RoomType;
import com.hotelreservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    
    @Autowired
    private RoomService roomService;
    
    @PostMapping
    public ResponseEntity<ApiResponse> addRoom(@RequestBody Room room) {
        Room savedRoom = roomService.addRoom(room);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ApiResponse(true, "Room added successfully", savedRoom));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getRoomById(@PathVariable Long id) {
        Optional<Room> room = roomService.getRoomById(id);
        if (room.isPresent()) {
            return ResponseEntity.ok(room.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse(false, "Room not found", null));
    }
    
    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Room>> getRoomsByHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByHotelId(hotelId));
    }
    
    @GetMapping("/hotel/{hotelId}/available")
    public ResponseEntity<List<Room>> getAvailableRoomsByHotel(@PathVariable Long hotelId) {
        return ResponseEntity.ok(roomService.getAvailableRoomsByHotelId(hotelId));
    }
    
    @GetMapping("/type/{roomType}")
    public ResponseEntity<List<Room>> getRoomsByType(@PathVariable String roomType) {
        return ResponseEntity.ok(roomService.getRoomsByType(RoomType.valueOf(roomType)));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody Room room) {
        try {
            Room updatedRoom = roomService.updateRoom(id, room);
            return ResponseEntity.ok(new ApiResponse(true, "Room updated successfully", updatedRoom));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok(new ApiResponse(true, "Room deleted successfully", null));
    }
    
    @PutMapping("/{id}/mark-unavailable")
    public ResponseEntity<ApiResponse> markRoomUnavailable(@PathVariable Long id) {
        roomService.markRoomAsUnavailable(id);
        return ResponseEntity.ok(new ApiResponse(true, "Room marked as unavailable", null));
    }
    
    @PutMapping("/{id}/mark-available")
    public ResponseEntity<ApiResponse> markRoomAvailable(@PathVariable Long id) {
        roomService.markRoomAsAvailable(id);
        return ResponseEntity.ok(new ApiResponse(true, "Room marked as available", null));
    }
}
