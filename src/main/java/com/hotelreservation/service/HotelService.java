package com.hotelreservation.service;

import com.hotelreservation.model.Hotel;
import com.hotelreservation.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    
    @Autowired
    private HotelRepository hotelRepository;
    
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    
    public Optional<Hotel> getHotelById(Long id) {
        return hotelRepository.findById(id);
    }
    
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }
    
    public List<Hotel> getActiveHotels() {
        return hotelRepository.findByActiveTrue();
    }
    
    public List<Hotel> getHotelsByCity(String city) {
        return hotelRepository.findByCity(city);
    }
    
    public List<Hotel> searchHotelsByName(String name) {
        return hotelRepository.findByNameContainingIgnoreCase(name);
    }
    
    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        Optional<Hotel> existingHotel = hotelRepository.findById(id);
        if (existingHotel.isPresent()) {
            Hotel hotel = existingHotel.get();
            hotel.setName(updatedHotel.getName());
            hotel.setDescription(updatedHotel.getDescription());
            hotel.setAddress(updatedHotel.getAddress());
            hotel.setCity(updatedHotel.getCity());
            hotel.setCountry(updatedHotel.getCountry());
            hotel.setPhoneNumber(updatedHotel.getPhoneNumber());
            hotel.setEmail(updatedHotel.getEmail());
            hotel.setRating(updatedHotel.getRating());
            hotel.setAmenities(updatedHotel.getAmenities());
            hotel.setActive(updatedHotel.getActive());
            return hotelRepository.save(hotel);
        }
        throw new IllegalArgumentException("Hotel not found");
    }
    
    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
    
    public void deactivateHotel(Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            hotel.get().setActive(false);
            hotelRepository.save(hotel.get());
        }
    }
}
