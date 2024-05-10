package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.SpecificationTextProject;
import com.example.royalhouseuser.repo.SpecificationsTextsProjectRepo;
import com.example.royalhouseuser.service.SpecificationTextProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecificationTextsServiceImp implements SpecificationTextProjectService {
    private final SpecificationsTextsProjectRepo specificationsTextsProjectRepo;
    @Override
    public List<SpecificationTextProject> getAllByProject(Project project) {
        return specificationsTextsProjectRepo.getAllByProject(project);
    }
}
