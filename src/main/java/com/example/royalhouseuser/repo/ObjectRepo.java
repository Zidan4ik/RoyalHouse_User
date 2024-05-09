package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepo extends JpaRepository<Object,Long> {
    List<Object> getAllByProject(Project project);
}
