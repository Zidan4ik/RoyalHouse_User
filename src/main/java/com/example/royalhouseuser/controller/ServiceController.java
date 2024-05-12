package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.entity.Service_;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.mapper.MapperSection;
import com.example.royalhouseuser.mapper.MapperService;
import com.example.royalhouseuser.model.BannerServiceDTO;
import com.example.royalhouseuser.model.ServiceDTO;
import com.example.royalhouseuser.repo.SectionRepo;
import com.example.royalhouseuser.service.serviceimp.SectionServiceImp;
import com.example.royalhouseuser.service.serviceimp.ServiceServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ServiceController {
    private final ServiceServiceImp serviceServiceImp;
    private final SectionServiceImp sectionServiceImp;
    @GetMapping("/services")
    public ModelAndView viewServices(){
        ModelAndView model = new ModelAndView("service/services-view");

        Optional<Section> sectionService = sectionServiceImp.getByType(SectionType.service);
        BannerServiceDTO dtoService = MapperSection.toDTOService(sectionService.get());

        List<Service_> all = serviceServiceImp.getAll();
        List<ServiceDTO> dtoList = MapperService.toDTOList(all);
        model.addObject("section",dtoService);
        model.addObject("service",dtoList);
        return model;
    }

    @GetMapping("/services/{id}/view")
    public ModelAndView viewService(@PathVariable(name = "id")Long id){
        ModelAndView model = new ModelAndView("service/service-view");
        Optional<Service_> serviceById = serviceServiceImp.getById(id);
        ServiceDTO dto = MapperService.toDTO(serviceById.get());

        model.addObject("service",dto);
        return model;
    }
}