package com.example.royalhouseuser.entity.unifier;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjectUnifier {
    private Project project;
    private Object object;
}
