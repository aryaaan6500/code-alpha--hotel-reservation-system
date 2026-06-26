package com.hotelreservation.controller;

import com.hotelreservation.model.User;
import com.hotelreservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", registeredUser));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ApiResponse(false, e.getMessage(), null));
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request) {
        Optional<User> user = userService.loginUser(request.getEmail(), request.getPassword());
        if (user.isPresent()) {
            return ResponseEntity.ok(new ApiResponse(true, "Login successful", user.get()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(new ApiResponse(false, "Invalid credentials", null));
    }
    
    static class LoginRequest {
        public String email;
        public String password;
        
        public String getEmail() { return email; }
        public String getPassword() { return password; }
    }
}

class ApiResponse {
    private boolean success;
    private String message;
    private Object data;
    
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Object getData() { return data; }
}
