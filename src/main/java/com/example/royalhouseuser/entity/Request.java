package com.example.royalhouseuser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "requests")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 40)
    private String fullName;
    @Column(length = 40)
    private String phone;
    @Column(length = 40)
    private String email;
    @Column(nullable = true,length = 215)
    private String comment;
    private LocalDateTime date;
    private boolean isReported;

    public Request(String fullName, String phone) {
        this.fullName = fullName;
        this.phone = phone;
    }
}
