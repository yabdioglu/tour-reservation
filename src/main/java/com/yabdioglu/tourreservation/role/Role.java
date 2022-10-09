package com.yabdioglu.tourreservation.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yabdioglu.tourreservation.user.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int id;

    @Column(name = "role_name", unique = true)
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.EAGER)
    private Set<User> users = new HashSet<>();
}
