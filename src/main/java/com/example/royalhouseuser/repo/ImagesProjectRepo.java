package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.ImagesProject;
import com.example.royalhouseuser.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagesProjectRepo extends JpaRepository<ImagesProject,Long> {
    List<ImagesProject> getAllByProject(Project project);
}
