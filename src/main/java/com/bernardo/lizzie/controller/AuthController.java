package com.bernardo.lizzie.controller;

import com.bernardo.lizzie.entity.User;
import com.bernardo.lizzie.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "${app.client.url") //yung dumadaan sa yml para makaabot sa frontend
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService == null) return ResponseEntity.status(500).body("Service missing");
        var registered = userService.register(user);
        registered.setPassword(null);
        return ResponseEntity.ok(registered);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        var user = userService.login(req.getEmail(), req.getPassword());
        if (user == null) return ResponseEntity.status(401).body("Invalid credentials");
        return ResponseEntity.ok(user);
    }

    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
