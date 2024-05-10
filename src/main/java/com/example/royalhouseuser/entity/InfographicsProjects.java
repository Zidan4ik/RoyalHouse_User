package com.example.royalhouseuser.entity;


import com.example.royalhouseuser.enums.InfographicsType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "infographics_projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InfographicsProjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private InfographicsType type;
    private String image;
    private String description;
    @ManyToOne
    private Project project;
}
