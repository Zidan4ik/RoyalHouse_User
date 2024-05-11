package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Service_;
import com.example.royalhouseuser.repo.ServiceRepo;
import com.example.royalhouseuser.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceServiceImp implements ServiceService {
    private final ServiceRepo serviceRepo;
    @Override
    public Optional<Service_> getById(Long id) {
        return serviceRepo.findById(id);
    }

    @Override
    public List<Service_> getAll() {
        return serviceRepo.findAll();
    }
}
