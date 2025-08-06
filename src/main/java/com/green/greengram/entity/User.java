package com.green.greengram.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class User extends UpdatedAt{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, length = 30)
    private String nick_name;

    @Column(nullable = false, length = 50, unique = true)
    private String uid;

    @Column(nullable = true, length = 100)
    private String pic;

    @Column(nullable = false, length = 100)
    private String upw;


}
