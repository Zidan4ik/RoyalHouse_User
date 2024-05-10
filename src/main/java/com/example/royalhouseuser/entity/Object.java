package com.example.royalhouseuser.entity;


import com.example.royalhouseuser.enums.Building;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "objects")
@NoArgsConstructor
@Data
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Building building;
    @Column(nullable = true)
    private double area;
    @Column(nullable = true)
    private double price;
    @Column(nullable = true)
    private double priceSquareMeter;
    @Column(nullable = true)
    private int rooms;
    @Column(nullable = true)
    private int storey;
    @Column(nullable = true)
    private int countStoreys;
    @Column(nullable = true)
    private LocalDateTime dateOfAddition;

    @Column(nullable = true)
    private String imageFirst;
    @Column(nullable = true)
    private String imageSecond;
    @Column(nullable = true)
    private String imageThird;
    @ManyToOne
    private Project project;

}
