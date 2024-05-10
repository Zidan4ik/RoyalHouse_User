package com.example.royalhouseuser.entity;

import com.example.royalhouseuser.enums.ImageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images_projects")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ImagesProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ImageType type;

    private String imageFirst;
    private String imageSecond;
    private String imageThird;

    @ManyToOne
    private Project project;
}
