package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.TextProject;

import java.util.List;

public interface TextsProjectService {
    List<TextProject> getAllByProject(Project project);
}
