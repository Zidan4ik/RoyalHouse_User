package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.ImagesProject;
import com.example.royalhouseuser.entity.Project;

import java.util.List;

public interface ImagesProjectService {
    List<ImagesProject> getAllByProject(Project project);
}
