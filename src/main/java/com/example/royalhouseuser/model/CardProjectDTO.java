package com.example.royalhouseuser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardProjectDTO {
    private Long id;
    private String banner;
    private List<InfographicProjectDTO> infographicsMain;
    private String textAboutCompany;
    private ImagesProjectDTO imagesProjectDTOAboutCompany;

    private String textDestination;
    private Double length;
    private Double width;

    private String textInfrastructure;
    private ImagesProjectDTO imagesProjectDTOInfrastructure;
    private List<InfographicProjectDTO> infographicsInfrastructure;

    private String textApartment;
    private ImagesProjectDTO imagesProjectDTOApartment;
    private List<InfographicProjectDTO> infographicsApartment;

    private String panorama;
    private List<String> specificationsTexts;

    public String linkBanner() {
        return "/uploads/project/banner/" + id + "/" + banner;
    }
    public String linkPanorama() {
        return "/uploads/project/panorama/" + id + "/" + panorama;
    }
}
