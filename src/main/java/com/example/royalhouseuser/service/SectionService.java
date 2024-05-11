package com.example.royalhouseuser.service;


import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;

import java.util.Optional;

public interface SectionService{
    Optional<Section> getByType(SectionType type);
}
