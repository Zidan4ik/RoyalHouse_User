package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerCompanyDTO {
    private Long id;
    private String text;
    private String description;
    private String banner;
    private String image1;
    private String image2;
    private String title;
    public String linkBanner(){
        return "/uploads/banner/about-company/"+id+"/banner/"+banner;
    }
    public String linkImage1(){
        return "/uploads/banner/about-company/"+id+"/images/"+image1;
    }
    public String linkImage2(){
        return "/uploads/banner/about-company/"+id+"/images/"+image2;
    }
}
