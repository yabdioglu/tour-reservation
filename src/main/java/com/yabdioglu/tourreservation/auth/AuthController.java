package com.yabdioglu.tourreservation.auth;

import com.yabdioglu.tourreservation.shared.CurrentUser;
import com.yabdioglu.tourreservation.user.UserRepository;
import com.yabdioglu.tourreservation.user.User;
import com.yabdioglu.tourreservation.user.vm.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0")
public class AuthController {

    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/auth")
    ResponseEntity<?> handleAuthentication(@CurrentUser User user) {
        return ResponseEntity.ok(new UserResponse(user));
    }
}
