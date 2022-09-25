package com.yabdioglu.tourreservation.user.vm;

import com.yabdioglu.tourreservation.user.User;
import lombok.Data;

@Data
public class UserResponse {

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
    }
}
