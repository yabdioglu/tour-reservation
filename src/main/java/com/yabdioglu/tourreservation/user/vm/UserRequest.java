package com.yabdioglu.tourreservation.user.vm;

import lombok.Data;

@Data
public class UserRequest {

    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;
}
