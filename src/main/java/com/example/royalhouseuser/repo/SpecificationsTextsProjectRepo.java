package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.SpecificationTextProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationsTextsProjectRepo extends JpaRepository<SpecificationTextProject,Long> {
    List<SpecificationTextProject> getAllByProject(Project project);
}
