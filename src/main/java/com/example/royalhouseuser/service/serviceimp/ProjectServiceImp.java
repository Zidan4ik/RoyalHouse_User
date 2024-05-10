package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.model.ProjectDTO;
import com.example.royalhouseuser.repo.ProjectRepo;
import com.example.royalhouseuser.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ProjectDTO> fillingAnotherBlocks(List<ProjectDTO> projects){
        for (int i=0;i<8;i++){
            if(projects.size()<8){
                projects.add(new ProjectDTO());
            }
        }
        return projects;
    }
    public List<ProjectDTO> sortByBlock(List<ProjectDTO> list){
        List<ProjectDTO> listNull = new ArrayList<>();
        fillingAnotherBlocks(listNull);

        for (ProjectDTO l:list){
            listNull.set(Math.toIntExact(l.getIdBlock()-1),l);
        }
        return listNull;
    }
}
