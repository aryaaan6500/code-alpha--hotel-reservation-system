package com.hotelreservation.controller;

import com.hotelreservation.model.Reservation;
import com.hotelreservation.model.ReservationStatus;
import com.hotelreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody Reservation reservation) {
        try {
            if (!reservationService.isRoomAvailable(reservation.getRoom().getId(), 
                reservation.getCheckInDate(), reservation.getCheckOutDate())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ApiResponse(false, "Room not available for selected dates", null));
            }
            Reservation savedReservation = reservationService.createReservation(reservation);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(true, "Reservation created successfully", savedReservation));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        if (reservation.isPresent()) {
            return ResponseEntity.ok(reservation.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse(false, "Reservation not found", null));
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUserId(userId));
    }
    
    @GetMapping("/room/{roomId}")
    public ResponseEntity<List<Reservation>> getReservationsByRoom(@PathVariable Long roomId) {
        return ResponseEntity.ok(reservationService.getReservationsByRoomId(roomId));
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Reservation>> getReservationsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(reservationService.getReservationsByStatus(ReservationStatus.valueOf(status)));
    }
    
    @GetMapping("/date-range")
    public ResponseEntity<List<Reservation>> getReservationsByDateRange(
        @RequestParam LocalDate startDate,
        @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(reservationService.getReservationsByDateRange(startDate, endDate));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        try {
            Reservation updatedReservation = reservationService.updateReservation(id, reservation);
            return ResponseEntity.ok(new ApiResponse(true, "Reservation updated successfully", updatedReservation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @PutMapping("/{id}/confirm")
    public ResponseEntity<?> confirmReservation(@PathVariable Long id) {
        try {
            Reservation reservation = reservationService.confirmReservation(id);
            return ResponseEntity.ok(new ApiResponse(true, "Reservation confirmed", reservation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @PutMapping("/{id}/check-in")
    public ResponseEntity<?> checkInReservation(@PathVariable Long id) {
        try {
            Reservation reservation = reservationService.checkInReservation(id);
            return ResponseEntity.ok(new ApiResponse(true, "Check-in successful", reservation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @PutMapping("/{id}/check-out")
    public ResponseEntity<?> checkOutReservation(@PathVariable Long id) {
        try {
            Reservation reservation = reservationService.checkOutReservation(id);
            return ResponseEntity.ok(new ApiResponse(true, "Check-out successful", reservation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @PutMapping("/{id}/cancel")
    public ResponseEntity<?> cancelReservation(@PathVariable Long id) {
        try {
            Reservation reservation = reservationService.cancelReservation(id);
            return ResponseEntity.ok(new ApiResponse(true, "Reservation cancelled", reservation));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.ok(new ApiResponse(true, "Reservation deleted successfully", null));
    }
}
