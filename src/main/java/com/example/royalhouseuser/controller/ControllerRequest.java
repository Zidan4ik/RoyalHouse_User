package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Contact;
import com.example.royalhouseuser.entity.Request;
import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.mapper.MapperContact;
import com.example.royalhouseuser.mapper.MapperRequest;
import com.example.royalhouseuser.mapper.MapperSection;
import com.example.royalhouseuser.model.BannerCompanyDTO;
import com.example.royalhouseuser.model.ContactDTO;
import com.example.royalhouseuser.model.RequestDTO;
import com.example.royalhouseuser.service.serviceimp.ContactServiceImp;
import com.example.royalhouseuser.service.serviceimp.RequestServiceImp;
import com.example.royalhouseuser.service.serviceimp.SectionServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerRequest {
    private final RequestServiceImp requestServiceImp;
    private final ContactServiceImp contactServiceImp;

    @GetMapping("/request")
    public ModelAndView viewRequest(@ModelAttribute(name = "request")RequestDTO dto){
        ModelAndView model = new ModelAndView("request/request-add");
        return model;
    }
    @PostMapping("/request/add")
    public ModelAndView addRequestPage(@ModelAttribute(name = "request") RequestDTO dto){
        ModelAndView model = new ModelAndView("redirect:/user/projects");

        requestServiceImp.save(MapperRequest.toEntity(dto));
        return model;
    }

    @PostMapping("/request/add-order")
    public ModelAndView addRequest(@RequestParam(name = "phone")String phone,
                                   @RequestParam(name = "name")String name){
        ModelAndView model = new ModelAndView("redirect:/user/projects");
        requestServiceImp.save(MapperRequest.toEntity(new RequestDTO(name,phone)));
        return model;
    }
    @ModelAttribute("contact")
    public ContactDTO showCountObjects() {
        Optional<Contact> byId = contactServiceImp.getById(1l);
        return MapperContact.toDTO(byId.get());
    }
}
