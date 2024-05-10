package com.example.royalhouseuser.entity;


import com.example.royalhouseuser.enums.TextType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "texts_projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TextProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TextType type;
    private String description;
    @ManyToOne
    private Project project;
}
