package com.yabdioglu.tourreservation.role;

import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(int roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    public void createRole(String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
    }
}
