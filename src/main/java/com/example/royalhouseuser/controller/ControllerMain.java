package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.*;
import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.unifier.CardProjectUnifier;
import com.example.royalhouseuser.entity.unifier.ObjectUnifier;
import com.example.royalhouseuser.entity.unifier.ProjectUnifier;
import com.example.royalhouseuser.mapper.MapperCardProject;
import com.example.royalhouseuser.mapper.MapperObject;
import com.example.royalhouseuser.mapper.MapperProject;
import com.example.royalhouseuser.model.CardProjectDTO;
import com.example.royalhouseuser.model.ObjectDTO;
import com.example.royalhouseuser.model.ProjectDTO;
import com.example.royalhouseuser.service.serviceimp.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.nio.file.Path;
import java.util.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerMain {
    private final ProjectServiceImp projectServiceImp;
    private final ObjectServiceImp objectServiceImp;
    private final TextProjectServiceImp textProjectServiceImp;
    private final SpecificationTextsServiceImp specificationTextsServiceImp;
    private final ImagesProjectServiceImp imagesProjectServiceImp;
    private final InfographicServiceImp infographicServiceImp;
    private final RequestServiceImp requestServiceImp;

    @GetMapping("/projects")
    public ModelAndView viewMain() {
        ModelAndView model = new ModelAndView("main/main");
        List<Project> projects = projectServiceImp.getAllWithBlock();

        List<ObjectUnifier> unifierObject = new ArrayList<>();
        for (Project p : projects) {
            List<Object> allByProject = objectServiceImp.getAllByProject(p);
            for (Object o : allByProject) {
                unifierObject.add(new ObjectUnifier(p, o));
            }
        }

        List<ProjectUnifier> unifierProject = new ArrayList<>();
        for (Project p : projects) {
            List<Object> objects = objectServiceImp.getAllByProject(p);
            unifierProject.add(new ProjectUnifier(p, objects));
        }

        List<ProjectDTO> dtoList = projectServiceImp.sortByBlock(MapperProject.toDTOList(unifierProject));


        Collections.shuffle(unifierObject);
        List<ObjectDTO> randomObjects;

        if (unifierObject.size() > 9) {
            randomObjects = MapperObject.toDTOList(unifierObject.subList(0, 9));
        } else {
            randomObjects = MapperObject.toDTOList(unifierObject);
        }


        model.addObject("projects", dtoList);
        model.addObject("objects", randomObjects);
        return model;
    }

    @GetMapping("/projects/{id}/view")
    public ModelAndView viewProject(@PathVariable(name = "id") Long id) {
        ModelAndView model = new ModelAndView("main/project-view");

        Optional<Project> projectById = projectServiceImp.getById(id);
        List<InfographicsProjects> infographics = infographicServiceImp.getByProject(projectById.get());
        List<ImagesProject> images = imagesProjectServiceImp.getAllByProject(projectById.get());
        List<TextProject> texts = textProjectServiceImp.getAllByProject(projectById.get());
        List<SpecificationTextProject> specificationsTexts = specificationTextsServiceImp.getAllByProject(projectById.get());

        CardProjectDTO dto = MapperCardProject.toDTO(new CardProjectUnifier(projectById.get(), images, infographics, texts, specificationsTexts));
        List<Object> objectsByProject = objectServiceImp.getAllByProject(projectById.get());
        List<ObjectUnifier> unifier = new ArrayList<>();
        for (Object o:objectsByProject){
            unifier.add(new ObjectUnifier(projectById.get(),o));
        }
        List<ObjectDTO> objects = MapperObject.toDTOList(unifier);

        List<Project> projects = projectServiceImp.getAllWithBlock();
        List<ProjectUnifier> unifierProject = new ArrayList<>();
        for (Project p : projects) {
            List<Object> objects2 = objectServiceImp.getAllByProject(p);
            unifierProject.add(new ProjectUnifier(p, objects2));
        }

        List<ProjectDTO> dtoList = projectServiceImp.sortByBlock(MapperProject.toDTOList(unifierProject));

        model.addObject("project", dto);
        model.addObject("objects", objects);
        model.addObject("projectBlock",dtoList);
        return model;
    }

    @PostMapping("/projects/add-order")
    public ModelAndView model(@RequestParam(name = "phone")String phone,
                              @RequestParam(name = "name")String name){
        ModelAndView model = new ModelAndView("redirect:/user/projects");
        Request request = new Request();
        request.setPhone(phone);
        request.setFullName(name);

        requestServiceImp.save(request);
        return model;
    }
}
