package com.example.royalhouseuser.service;


import com.example.royalhouseuser.entity.InfographicsProjects;
import com.example.royalhouseuser.entity.Project;

import java.util.List;

public interface InfographicProjectService {
    List<InfographicsProjects> getAll();
    List<InfographicsProjects> getByProject(Project project);
}
