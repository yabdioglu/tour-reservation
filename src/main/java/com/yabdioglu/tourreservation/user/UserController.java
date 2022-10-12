package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.shared.GenericResponse;
import com.yabdioglu.tourreservation.user.vm.UserRequest;
import com.yabdioglu.tourreservation.user.vm.UserResponse;
import com.yabdioglu.tourreservation.user.vm.UserResponseWithRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/1.0")
@CrossOrigin("https://tour-reservation-admin.herokuapp.com")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
//    @PreAuthorize("hasAuthority('ADMIN')")
    public GenericResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return new GenericResponse("user created");
    }

    @GetMapping("/users")
    // has admin +
    public Page<UserResponseWithRoles> getAllUsers(Pageable pageable) {
        return userService.getAllUsers(pageable).map(UserResponseWithRoles::new);
    }

    @GetMapping("/users/{id}")
    public UserResponse findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return new UserResponse(user);
    }

    @DeleteMapping("/users/{id}")
    public GenericResponse deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new GenericResponse("user deleted");
    }
}
