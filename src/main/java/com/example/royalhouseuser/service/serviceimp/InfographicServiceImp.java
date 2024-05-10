package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.InfographicsProjects;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.repo.InfographicsProjectRepo;
import com.example.royalhouseuser.service.InfographicProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InfographicServiceImp implements InfographicProjectService {
    private final InfographicsProjectRepo infographicsProjectRepo;
    @Override
    public List<InfographicsProjects> getAll() {
        return infographicsProjectRepo.findAll();
    }

    @Override
    public List<InfographicsProjects> getByProject(Project project) {
        return infographicsProjectRepo.getAllByProject(project);
    }
}
