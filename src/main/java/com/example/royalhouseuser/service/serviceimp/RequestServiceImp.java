package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Request;
import com.example.royalhouseuser.repo.RequestRepo;
import com.example.royalhouseuser.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RequestServiceImp implements RequestService {
    private final RequestRepo requestRepo;
    @Override
    public void save(Request request) {
        requestRepo.save(request);
    }
}
