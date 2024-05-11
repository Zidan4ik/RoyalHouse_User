package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.repo.SectionRepo;
import com.example.royalhouseuser.service.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SectionServiceImp implements SectionService {
    private final SectionRepo sectionRepo;
    @Override
    public Optional<Section> getByType(SectionType type) {
        return sectionRepo.getByType(type);
    }
}
