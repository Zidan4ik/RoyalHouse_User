package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.SecondaryMarketBanner;
import com.example.royalhouseuser.entity.unifier.ObjectUnifier;
import com.example.royalhouseuser.entity.unifier.ProjectUnifier;
import com.example.royalhouseuser.mapper.MapperMarketBanner;
import com.example.royalhouseuser.mapper.MapperObject;
import com.example.royalhouseuser.mapper.MapperProject;
import com.example.royalhouseuser.model.BannerMarketDTO;
import com.example.royalhouseuser.model.ObjectDTO;
import com.example.royalhouseuser.model.ProjectDTO;
import com.example.royalhouseuser.service.serviceimp.ObjectServiceImp;
import com.example.royalhouseuser.service.serviceimp.ProjectServiceImp;
import com.example.royalhouseuser.service.serviceimp.SecondaryMarketServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerMarket {
    private final ObjectServiceImp objectServiceImp;
    private final SecondaryMarketServiceImp secondaryMarketServiceImp;
    private final ProjectServiceImp projectServiceImp;
    @GetMapping("/secondary-market")
    public ModelAndView viewObjects(){
        ModelAndView model = new ModelAndView("secondary-market/objects-view");
        List<SecondaryMarketBanner> banners = secondaryMarketServiceImp.getAll();

        List<Project> projects = projectServiceImp.getAllWithBlock();
        List<ObjectUnifier> unifierObject = new ArrayList<>();
        for (Project p : projects) {
            List<Object> allByProject = objectServiceImp.getAllByProject(p);
            for (Object o : allByProject) {
                unifierObject.add(new ObjectUnifier(p, o));
            }
        }
        Collections.shuffle(unifierObject);
        List<ObjectDTO> randomObjects;

        if (unifierObject.size() > 9) {
            randomObjects = MapperObject.toDTOList(unifierObject.subList(0, 9));
        } else {
            randomObjects = MapperObject.toDTOList(unifierObject);
        }

        List<BannerMarketDTO> bannersDTO = MapperMarketBanner.toDTOList(banners);
        model.addObject("banners",bannersDTO);
        model.addObject("objects",randomObjects);
        return model;
    }

    @GetMapping("/secondary-market/{id}/view")
    public ModelAndView viewObject(@PathVariable(name = "id")Long id){
        ModelAndView model = new ModelAndView("secondary-market/object-view");
        Optional<Object> objectBD = objectServiceImp.getById(id);
        Optional<Project> projectBD = projectServiceImp.getById(objectBD.get().getProject().getId());

        ObjectDTO cardObjectDTO = MapperObject.toDTO(new ObjectUnifier(projectBD.get(), objectBD.get()));

        List<SecondaryMarketBanner> banners = secondaryMarketServiceImp.getAll();
        List<BannerMarketDTO> bannersDTO = MapperMarketBanner.toDTOList(banners);
        model.addObject("banners",bannersDTO);
        model.addObject("object",cardObjectDTO);
        return model;
    }
}
