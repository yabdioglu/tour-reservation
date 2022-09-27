package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.shared.GenericResponse;
import com.yabdioglu.tourreservation.user.User;
import com.yabdioglu.tourreservation.user.UserService;
import com.yabdioglu.tourreservation.user.vm.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public GenericResponse createUser(@Valid @RequestBody User user) {
        userService.createUser(user);
        return new GenericResponse("user created");
    }

    @GetMapping("/users")
    public Page<UserResponse> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable).map(UserResponse::new);
    }

    @GetMapping("/users/{id}")
    public UserResponse findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new UserResponse(user);
    }
}
