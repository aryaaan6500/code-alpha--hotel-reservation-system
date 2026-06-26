package com.hotelreservation.service;

import com.hotelreservation.model.Room;
import com.hotelreservation.model.RoomType;
import com.hotelreservation.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    
    @Autowired
    private RoomRepository roomRepository;
    
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }
    
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    
    public List<Room> getRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId);
    }
    
    public List<Room> getAvailableRoomsByHotelId(Long hotelId) {
        return roomRepository.findByHotelIdAndAvailableTrue(hotelId);
    }
    
    public List<Room> getRoomsByType(RoomType roomType) {
        return roomRepository.findByRoomType(roomType);
    }
    
    public Optional<Room> getRoomByRoomNumberAndHotel(String roomNumber, Long hotelId) {
        return roomRepository.findByRoomNumberAndHotelId(roomNumber, hotelId);
    }
    
    public Room updateRoom(Long id, Room updatedRoom) {
        Optional<Room> existingRoom = roomRepository.findById(id);
        if (existingRoom.isPresent()) {
            Room room = existingRoom.get();
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setRoomType(updatedRoom.getRoomType());
            room.setPricePerNight(updatedRoom.getPricePerNight());
            room.setCapacity(updatedRoom.getCapacity());
            room.setAvailable(updatedRoom.getAvailable());
            room.setDescription(updatedRoom.getDescription());
            room.setAmenities(updatedRoom.getAmenities());
            return roomRepository.save(room);
        }
        throw new IllegalArgumentException("Room not found");
    }
    
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
    
    public void markRoomAsUnavailable(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            room.get().setAvailable(false);
            roomRepository.save(room.get());
        }
    }
    
    public void markRoomAsAvailable(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isPresent()) {
            room.get().setAvailable(true);
            roomRepository.save(room.get());
        }
    }
}
