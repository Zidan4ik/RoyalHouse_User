package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.repo.ObjectRepo;
import com.example.royalhouseuser.service.ObjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjectServiceImp implements ObjectService {
    private final ObjectRepo objectRepo;

    @Override
    public List<Object> getAll() {
        return objectRepo.findAll();
    }

    @Override
    public Optional<Object> getById(Long id) {
        return objectRepo.findById(id);
    }
    public List<Object> getAllByProject(Project project){
        return objectRepo.getAllByProject(project);
    }
}
