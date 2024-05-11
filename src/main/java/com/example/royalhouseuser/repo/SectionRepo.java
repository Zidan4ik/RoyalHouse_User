package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepo extends JpaRepository<Section,Long> {
    Optional<Section> getByType(SectionType type);
}
