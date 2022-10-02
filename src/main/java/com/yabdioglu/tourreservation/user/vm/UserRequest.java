package com.yabdioglu.tourreservation.user.vm;

import com.yabdioglu.tourreservation.user.UniqueUsername;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class UserRequest {

    @UniqueUsername
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "must be a well-formed email address")
    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String password;
}
