package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.mapper.MapperProject;
import com.example.royalhouseuser.model.ProjectDTO;
import com.example.royalhouseuser.service.serviceimp.ObjectServiceImp;
import com.example.royalhouseuser.service.serviceimp.ProjectServiceImp;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerMain {
    private final ProjectServiceImp projectServiceImp;
    private final ObjectServiceImp objectServiceImp;
    @GetMapping("/main")
    public ModelAndView viewMain(){
        ModelAndView model = new ModelAndView("main/main");
        List<Project> blocks = projectServiceImp.getAllWithBlock();
//        List<ProjectDTO> dtoList = MapperProject.toDTOList(blocks);
        ProjectDTO dto = MapperProject.toDTO(blocks.get(0));

//        List<Object> project = objectServiceImp.getAllByProject(projectServiceImp.getById(1l).get());
        return model;
    }
}
