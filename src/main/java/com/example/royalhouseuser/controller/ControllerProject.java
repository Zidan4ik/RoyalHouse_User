package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.*;
import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.unifier.CardProjectUnifier;
import com.example.royalhouseuser.entity.unifier.ObjectUnifier;
import com.example.royalhouseuser.entity.unifier.ProjectUnifier;
import com.example.royalhouseuser.mapper.MapperCardProject;
import com.example.royalhouseuser.mapper.MapperContact;
import com.example.royalhouseuser.mapper.MapperObject;
import com.example.royalhouseuser.mapper.MapperProject;
import com.example.royalhouseuser.model.CardProjectDTO;
import com.example.royalhouseuser.model.ContactDTO;
import com.example.royalhouseuser.model.ObjectDTO;
import com.example.royalhouseuser.model.ProjectDTO;
import com.example.royalhouseuser.service.serviceimp.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerProject {
    private final ProjectServiceImp projectServiceImp;
    private final ObjectServiceImp objectServiceImp;
    private final TextProjectServiceImp textProjectServiceImp;
    private final SpecificationTextsServiceImp specificationTextsServiceImp;
    private final ImagesProjectServiceImp imagesProjectServiceImp;
    private final InfographicServiceImp infographicServiceImp;
    private final ContactServiceImp contactServiceImp;
    @GetMapping("/projects")
    public ModelAndView viewMain() {
        ModelAndView model = new ModelAndView("project/projects");
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
        ModelAndView model = new ModelAndView("project/project-view");

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
        model.addObject("address",projectById.get().getAddress());
        model.addObject("project", dto);
        model.addObject("objects", objects);
        model.addObject("projectBlock",dtoList);
        return model;
    }


    @ModelAttribute("contact")
    public ContactDTO showCountObjects() {
        Optional<Contact> byId = contactServiceImp.getById(1l);
        if(!byId.isEmpty()){
            return MapperContact.toDTO(byId.get());
        }else{
            return null;
        }
    }
}
