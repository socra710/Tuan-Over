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

    @Column(length = 18, nullable = false)
    private String comCd;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 500, nullable = true)
    private String tagNames;
}
