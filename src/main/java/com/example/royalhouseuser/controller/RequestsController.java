package com.example.royalhouseuser.controller;

import com.example.royalhouseuser.entity.Request;
import com.example.royalhouseuser.service.serviceimp.RequestServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user/request")
public class RequestsController {
    private final RequestServiceImp requestServiceImp;
    @PostMapping("/add-order")
    public ModelAndView addRequest(@RequestParam(name = "phone")String phone,
                                   @RequestParam(name = "name")String name){
        ModelAndView model = new ModelAndView("redirect:/user/projects");

        requestServiceImp.save(new Request(name,phone));
        return model;
    }
}
