package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.user.User;
import com.yabdioglu.tourreservation.user.UserService;
import com.yabdioglu.tourreservation.user.vm.UserResponse;
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
    public UserResponse createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }
}
