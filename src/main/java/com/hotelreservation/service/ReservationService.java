package com.hotelreservation.service;

import com.hotelreservation.model.Reservation;
import com.hotelreservation.model.ReservationStatus;
import com.hotelreservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public Reservation createReservation(Reservation reservation) {
        // Calculate total price
        long days = java.time.temporal.ChronoUnit.DAYS.between(
            reservation.getCheckInDate(), 
            reservation.getCheckOutDate()
        );
        double totalPrice = reservation.getRoom().getPricePerNight() * days;
        reservation.setTotalPrice(totalPrice);
        
        return reservationRepository.save(reservation);
    }
    
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
    
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
    
    public List<Reservation> getReservationsByRoomId(Long roomId) {
        return reservationRepository.findByRoomId(roomId);
    }
    
    public List<Reservation> getReservationsByStatus(ReservationStatus status) {
        return reservationRepository.findByStatus(status);
    }
    
    public List<Reservation> getReservationsByDateRange(LocalDate startDate, LocalDate endDate) {
        return reservationRepository.findByCheckInDateBetween(startDate, endDate);
    }
    
    public List<Reservation> getConflictingReservations(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        return reservationRepository.findByRoomIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
            roomId, checkOutDate, checkInDate
        );
    }
    
    public boolean isRoomAvailable(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
        List<Reservation> conflicts = getConflictingReservations(roomId, checkInDate, checkOutDate);
        return conflicts.stream()
            .noneMatch(r -> r.getStatus() == ReservationStatus.CONFIRMED || 
                           r.getStatus() == ReservationStatus.CHECKED_IN);
    }
    
    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);
        if (existingReservation.isPresent()) {
            Reservation reservation = existingReservation.get();
            reservation.setCheckInDate(updatedReservation.getCheckInDate());
            reservation.setCheckOutDate(updatedReservation.getCheckOutDate());
            reservation.setNumberOfGuests(updatedReservation.getNumberOfGuests());
            reservation.setSpecialRequests(updatedReservation.getSpecialRequests());
            return reservationRepository.save(reservation);
        }
        throw new IllegalArgumentException("Reservation not found");
    }
    
    public Reservation confirmReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservation.get().setStatus(ReservationStatus.CONFIRMED);
            return reservationRepository.save(reservation.get());
        }
        throw new IllegalArgumentException("Reservation not found");
    }
    
    public Reservation checkInReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservation.get().setStatus(ReservationStatus.CHECKED_IN);
            return reservationRepository.save(reservation.get());
        }
        throw new IllegalArgumentException("Reservation not found");
    }
    
    public Reservation checkOutReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservation.get().setStatus(ReservationStatus.CHECKED_OUT);
            return reservationRepository.save(reservation.get());
        }
        throw new IllegalArgumentException("Reservation not found");
    }
    
    public Reservation cancelReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            reservation.get().setStatus(ReservationStatus.CANCELLED);
            return reservationRepository.save(reservation.get());
        }
        throw new IllegalArgumentException("Reservation not found");
    }
    
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
