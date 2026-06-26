package com.hotelreservation.repository;

import com.hotelreservation.model.Reservation;
import com.hotelreservation.model.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);
    List<Reservation> findByRoomId(Long roomId);
    List<Reservation> findByStatus(ReservationStatus status);
    List<Reservation> findByCheckInDateBetween(LocalDate startDate, LocalDate endDate);
    List<Reservation> findByRoomIdAndCheckInDateLessThanEqualAndCheckOutDateGreaterThanEqual(
        Long roomId, LocalDate checkOutDate, LocalDate checkInDate);
}
