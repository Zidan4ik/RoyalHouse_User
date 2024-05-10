package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.SpecificationTextProject;

import java.util.List;

public interface SpecificationTextProjectService {
    List<SpecificationTextProject> getAllByProject(Project project);
}
