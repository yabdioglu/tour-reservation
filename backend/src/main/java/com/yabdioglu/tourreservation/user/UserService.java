package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.user.vm.UserResponse;

public interface UserService {
    UserResponse createUser(User user);
}
