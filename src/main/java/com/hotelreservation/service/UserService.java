package com.hotelreservation.service;

import com.hotelreservation.model.User;
import com.hotelreservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        return userRepository.save(user);
    }
    
    public Optional<User> loginUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
    
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User updateUser(Long id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setAddress(updatedUser.getAddress());
            user.setCity(updatedUser.getCity());
            user.setCountry(updatedUser.getCountry());
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("User not found");
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
