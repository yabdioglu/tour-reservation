package com.yabdioglu.tourreservation.dto;

import com.yabdioglu.tourreservation.entity.User;
import lombok.Data;

@Data
public class UserResponse {

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
    }
}
