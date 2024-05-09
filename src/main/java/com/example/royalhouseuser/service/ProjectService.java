package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();
    Optional<Project> getById(Long id);
}
