package com.f1soft.turnovers.entity;

import lombok.Getter;
import javax.persistence.*;

@Getter
@Entity
@Table(name = "users")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30, nullable = false, unique = true)
    private String email;

    @Column(length = 30, nullable = false)
    private String name;
}
