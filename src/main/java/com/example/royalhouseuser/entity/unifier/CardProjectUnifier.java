package com.example.royalhouseuser.entity.unifier;

import com.example.royalhouseuser.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardProjectUnifier {
    private Project project;
    private List<ImagesProject> images;
    private List<InfographicsProjects> infographics;
    private List<TextProject> texts;
    private List<SpecificationTextProject> specificationsTexts;

}
