package com.example.shop.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tbl_roles")
@Data
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable=false)
    private String name;

}
