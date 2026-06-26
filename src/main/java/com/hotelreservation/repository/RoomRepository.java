package com.hotelreservation.repository;

import com.hotelreservation.model.Room;
import com.hotelreservation.model.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByHotelId(Long hotelId);
    List<Room> findByHotelIdAndAvailableTrue(Long hotelId);
    List<Room> findByRoomType(RoomType roomType);
    Optional<Room> findByRoomNumberAndHotelId(String roomNumber, Long hotelId);
}
