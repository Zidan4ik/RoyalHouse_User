package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.InfographicsProjects;
import com.example.royalhouseuser.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfographicsProjectRepo extends JpaRepository<InfographicsProjects,Long> {
    List<InfographicsProjects> getAllByProject(Project project);
}
