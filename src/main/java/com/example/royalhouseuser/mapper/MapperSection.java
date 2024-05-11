package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Section;
import com.example.royalhouseuser.enums.SectionType;
import com.example.royalhouseuser.model.BannerServiceDTO;

import org.springframework.stereotype.Service;

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
}
