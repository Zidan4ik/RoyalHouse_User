package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.SecondaryMarketBanner;
import com.example.royalhouseuser.model.BannerMarketDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperMarketBanner {
    public static BannerMarketDTO toDTO(SecondaryMarketBanner entity){
        BannerMarketDTO dto = new BannerMarketDTO();
        dto.setId(entity.getId());
        dto.setBanner(entity.getImage());
        dto.setLink(entity.getLink());
        dto.setText(entity.getText());

        return dto;
    }
    public static List<BannerMarketDTO> toDTOList(List<SecondaryMarketBanner> list){
        return list.stream()
                .map(MapperMarketBanner::toDTO)
                .collect(Collectors.toList());
    }
}
