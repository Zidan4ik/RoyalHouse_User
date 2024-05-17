package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Contact;
import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.mapper.MapperContact;
import com.example.royalhouseuser.mapper.MapperSection;
import com.example.royalhouseuser.model.BannerCompanyDTO;
import com.example.royalhouseuser.model.BannerServiceDTO;
import com.example.royalhouseuser.model.ContactDTO;
import com.example.royalhouseuser.service.serviceimp.ContactServiceImp;
import com.example.royalhouseuser.service.serviceimp.SectionServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ControllerAboutCompany {
    private final SectionServiceImp sectionServiceImp;
    private final ContactServiceImp contactServiceImp;
    @GetMapping("/about-company")
    public ModelAndView companyView(){
        ModelAndView model = new ModelAndView("about-company/about-company");
        Optional<Section> sectionBD = sectionServiceImp.getByType(SectionType.aboutCompany);

        BannerCompanyDTO company;
        if(!sectionBD.isEmpty()){
            company = MapperSection.toDTOCompany(sectionBD.get());
        }else{company=null;}

        model.addObject("section",company);
        return model;
    }
    @ModelAttribute("contact")
    public ContactDTO showCountObjects() {
        Optional<Contact> byId = contactServiceImp.getById(1l);
        return MapperContact.toDTO(byId.get());
    }
}
