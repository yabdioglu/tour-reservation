package com.yabdioglu.tourreservation.user;

import com.yabdioglu.tourreservation.error.NotFoundException;
import com.yabdioglu.tourreservation.role.Role;
import com.yabdioglu.tourreservation.role.RoleService;
import com.yabdioglu.tourreservation.user.vm.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void createUser(UserRequest userRequest) {
        User user = new User();
        convertToUser(userRequest, user);
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private void convertToUser(UserRequest userRequest, User user) {
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setUsername(userRequest.getUsername());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        setDefaultRole(user);
    }

    private void setDefaultRole(User user) {
        Set<Role> roleSet = new HashSet<>();
        if(roleService.findByName("USER") == null) {
            roleService.createRole("USER");
        }
        roleSet.add(roleService.findByName("USER"));
        user.setRoleSet(roleSet);
    }
}
