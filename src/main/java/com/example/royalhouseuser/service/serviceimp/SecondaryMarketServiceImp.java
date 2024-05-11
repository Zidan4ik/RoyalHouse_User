package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.SecondaryMarketBanner;
import com.example.royalhouseuser.repo.SecondaryMarketRepo;
import com.example.royalhouseuser.service.SecondaryMarketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecondaryMarketServiceImp implements SecondaryMarketService {
    private final SecondaryMarketRepo secondaryMarketRepo;
    @Override
    public Optional<SecondaryMarketBanner> getById(Long id) {
        return secondaryMarketRepo.findById(id);
    }

    @Override
    public List<SecondaryMarketBanner> getAll() {
        return secondaryMarketRepo.findAll();
    }
}
