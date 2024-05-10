package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.TextProject;
import com.example.royalhouseuser.repo.TextsProjectRepo;
import com.example.royalhouseuser.service.TextsProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextProjectServiceImp implements TextsProjectService {
    private final TextsProjectRepo textsProjectRepo;

    @Override
    public List<TextProject> getAllByProject(Project project) {
        return textsProjectRepo.getAllByProject(project);
    }
}
