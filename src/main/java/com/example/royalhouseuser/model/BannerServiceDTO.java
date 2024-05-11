package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerServiceDTO {
    private Long id;
    private String text;
    private String description;
    private String banner;
    private String title;
    public String linkBanner(){
        return "/uploads/banner/service/"+id+"/"+banner;
    }
}
