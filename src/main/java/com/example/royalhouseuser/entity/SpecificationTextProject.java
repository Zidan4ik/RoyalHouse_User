package com.example.royalhouseuser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "specifications_texts_projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpecificationTextProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String miniText;
    @ManyToOne
    private Project project;
}
