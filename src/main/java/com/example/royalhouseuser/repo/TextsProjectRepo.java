package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.TextProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.ProjectedPayload;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextsProjectRepo extends JpaRepository<TextProject,Long> {
    List<TextProject> getAllByProject(Project project);
}
