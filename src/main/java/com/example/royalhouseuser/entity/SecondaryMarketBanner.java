package com.example.royalhouseuser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "banner_secondary_market")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondaryMarketBanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String link;
    private String image;
}
