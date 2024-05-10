package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.ImagesProject;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.repo.ImagesProjectRepo;
import com.example.royalhouseuser.service.ImagesProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImagesProjectServiceImp implements ImagesProjectService {
    private final ImagesProjectRepo imagesProjectRepo;
    @Override
    public List<ImagesProject> getAllByProject(Project project) {
        return imagesProjectRepo.getAllByProject(project);
    }
}
