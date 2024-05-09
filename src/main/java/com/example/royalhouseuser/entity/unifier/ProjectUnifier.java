package com.example.royalhouseuser.entity.unifier;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProjectUnifier {
    private Project project;
    private List<Object> objects;
}
