package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.user.vm.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void createUser(UserRequest userRequest);

    User findById(Long id);

    Page<User> getAllUsers(Pageable pageable);

    void deleteById(Long id);
}
