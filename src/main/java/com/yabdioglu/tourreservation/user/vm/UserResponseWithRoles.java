package com.yabdioglu.tourreservation.user.vm;

import com.yabdioglu.tourreservation.role.Role;
import com.yabdioglu.tourreservation.user.User;
import lombok.Data;

import java.util.Set;

@Data
public class UserResponseWithRoles {

    private Long id;
    private String username;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private Set<Role> roles;

    public UserResponseWithRoles(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.phoneNumber = user.getPhoneNumber();
        this.roles = user.getRoleSet();
    }
}
