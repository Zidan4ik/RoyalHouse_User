package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.repo.ProjectRepo;
import com.example.royalhouseuser.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImp implements ProjectService {
    private final ProjectRepo projectRepo;
    @Override
    public List<Project> getAll() {
        return projectRepo.findAll();
    }

    @Override
    public Optional<Project> getById(Long id) {
        return projectRepo.findById(id);
    }
    public List<Project> getAllWithBlock(){
        return projectRepo.getAllByBlockIsNotNull();
    }
}
