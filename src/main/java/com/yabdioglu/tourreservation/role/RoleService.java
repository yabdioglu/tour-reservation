package com.yabdioglu.tourreservation.role;

public interface RoleService {

    Role findById(int roleId);

    Role findByName(String roleName);

    void createRole(String name);
}
