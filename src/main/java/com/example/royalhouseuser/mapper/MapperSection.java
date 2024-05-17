package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.model.BannerCompanyDTO;
import com.example.royalhouseuser.model.BannerServiceDTO;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MapperSection {
    public static BannerServiceDTO toDTOService(Section section){
        BannerServiceDTO dto = new BannerServiceDTO();
        if(section.getType().equals(SectionType.service)){
            dto.setId(section.getId());
            dto.setTitle(section.getTitle());
            dto.setBanner(section.getBanner());
            dto.setText(section.getText());
            dto.setDescription(section.getDescription());
            return dto;
        }
        return null;
    }
    public static BannerCompanyDTO toDTOCompany(Section section){
        BannerCompanyDTO dto = new BannerCompanyDTO();
        if(section.getType().equals(SectionType.aboutCompany)){
            dto.setId(section.getId());
            dto.setTitle(section.getTitle());
            dto.setBanner(section.getBanner());
            dto.setText(section.getText());
            dto.setDescription(extractTextBetweenTags(section.getDescription()));
            dto.setImage1(section.getImage1());
            dto.setImage2(section.getImage2());
            return dto;
        }
        return null;
    }

    public static String extractTextBetweenTags(String input) {
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

}
