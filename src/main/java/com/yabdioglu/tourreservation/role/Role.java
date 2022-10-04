package com.yabdioglu.tourreservation.role;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private int id;

    @Column(name = "role_name", unique = true)
    private String name;
}
