package com.f1soft.turnovers.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "links")
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int userId;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 500, nullable = true)
    private String tagNames;
}
