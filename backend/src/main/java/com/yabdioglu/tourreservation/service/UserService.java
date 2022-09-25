package com.yabdioglu.tourreservation.service;

import com.yabdioglu.tourreservation.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User createUser(User user);
}
