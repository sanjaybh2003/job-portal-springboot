package com.sanjay.jobportal.controller;

import com.sanjay.jobportal.model.User;
import com.sanjay.jobportal.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthController(UserService userService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestParam String username,
                                               @RequestParam String email,
                                               @RequestParam String password) {
        if (userService.getUserByEmail(email) != null) {
            return new ResponseEntity<>("Email already registered!", HttpStatus.BAD_REQUEST);
        }

        User.Role role = User.Role.USER; // Default role
        userService.registerUser(username, email, password, role);
        return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestParam String email,
                                            @RequestParam String password) {
        User user = userService.getUserByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>("Login successful for user: " + user.getUsername(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "API is working!";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "App is running";
    }
}
