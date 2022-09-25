package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.user.User;
import com.yabdioglu.tourreservation.user.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
