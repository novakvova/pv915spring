package com.example.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Badges", schema = "dbo")
public class Badge {
    @Id
    @Column(name="Id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Name", length = 40, nullable = false)
    private String name;
    @Column(name = "UserId")
    private int userId;
    @Column(name="Date", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
