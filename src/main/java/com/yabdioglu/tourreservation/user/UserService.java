package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.user.vm.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void createUser(User user);

    User findById(Long id);

    Page<User> getAllUsers(Pageable pageable);
}
