package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String banner;

    public String linkImage(){
        return "/uploads/service/image/"+id+"/"+image;
    }
    public String linkBanner(){
        return "/uploads/service/banner/"+id+"/"+banner;
    }
}
