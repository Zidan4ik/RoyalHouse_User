package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerMarketDTO {
    private Long id;
    private String text;
    private String banner;
    private String link;

    public String linkToBanner(){
        return "/uploads/banner/secondary-market/"+id+"/"+banner;
    }
}
