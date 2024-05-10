package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.ImagesProject;
import com.example.royalhouseuser.entity.InfographicsProjects;
import com.example.royalhouseuser.entity.SpecificationTextProject;
import com.example.royalhouseuser.entity.TextProject;
import com.example.royalhouseuser.entity.unifier.CardProjectUnifier;
import com.example.royalhouseuser.enums.ImageType;
import com.example.royalhouseuser.enums.InfographicsType;
import com.example.royalhouseuser.enums.TextType;
import com.example.royalhouseuser.model.CardProjectDTO;
import com.example.royalhouseuser.model.ImagesProjectDTO;
import com.example.royalhouseuser.model.InfographicProjectDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MapperCardProject {
    public static CardProjectDTO toDTO(CardProjectUnifier unifier){
        CardProjectDTO dto = new CardProjectDTO();
        dto.setId(unifier.getProject().getId());
        dto.setBanner(unifier.getProject().getBanner());
        dto.setLength(unifier.getProject().getLength());
        dto.setWidth(unifier.getProject().getWidth());
        dto.setPanorama(unifier.getProject().getImagePanorama());

        List<InfographicProjectDTO> infographicsMain = new ArrayList<>();
        List<InfographicProjectDTO> infographicsInfrastructure = new ArrayList<>();
        List<InfographicProjectDTO> infographicsApartment = new ArrayList<>();

        for (InfographicsProjects i:unifier.getInfographics()){
            if(i.getType().equals(InfographicsType.main)){
                infographicsMain.add(new InfographicProjectDTO(i.getId(),i.getType(),i.getImage(),i.getDescription()));
            }
            if(i.getType().equals(InfographicsType.infrastructure)){
                infographicsInfrastructure.add(new InfographicProjectDTO(i.getId(),i.getType(),i.getImage(),i.getDescription()));
            }
            if(i.getType().equals(InfographicsType.apartment)){
                infographicsApartment.add(new InfographicProjectDTO(i.getId(),i.getType(),i.getImage(),i.getDescription()));
            }
        }

        dto.setInfographicsMain(infographicsMain);
        dto.setInfographicsInfrastructure(infographicsInfrastructure);
        dto.setInfographicsApartment(infographicsApartment);

        for (TextProject t:unifier.getTexts()){
            if(t.getType().equals(TextType.aboutProject)){
                dto.setTextAboutCompany(t.getDescription());
            }
            if(t.getType().equals(TextType.destination)){
                dto.setTextDestination(t.getDescription());
            }
            if(t.getType().equals(TextType.infrastructure)){
                dto.setTextInfrastructure(t.getDescription());
            }
            if(t.getType().equals(TextType.apartments)){
                dto.setTextApartment(t.getDescription());
            }
        }


        for(ImagesProject i:unifier.getImages()){
            if(i.getType().equals(ImageType.aboutProject)){
                dto.setImagesProjectDTOAboutCompany(new ImagesProjectDTO(i.getId(),i.getType(),i.getImageFirst(),i.getImageSecond(),i.getImageThird()));
            }
            if(i.getType().equals(ImageType.infrastructure)){
               dto.setImagesProjectDTOInfrastructure(new ImagesProjectDTO(i.getId(),i.getType(),i.getImageFirst(),i.getImageSecond(),i.getImageThird()));
            }
            if(i.getType().equals(ImageType.apartment)){
                dto.setImagesProjectDTOApartment(new ImagesProjectDTO(i.getId(),i.getType(),i.getImageFirst(),i.getImageSecond(),i.getImageThird()));
            }
        }


        List<String> specificationsTexts = new ArrayList<>();
        for (SpecificationTextProject t:unifier.getSpecificationsTexts()){
            String text = t.getMiniText();
            if(text!=null){
                String clearValue = extractTextBetweenTags(text);
                specificationsTexts.add(clearValue);
            }
        }
        dto.setSpecificationsTexts(specificationsTexts);

        return dto;
    }

    public static String extractTextBetweenTags(String input) {
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }
}
