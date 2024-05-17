package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Service_;
import com.example.royalhouseuser.model.BannerServiceDTO;
import com.example.royalhouseuser.model.ServiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperService {
    public static ServiceDTO toDTO(Service_ entity){
        ServiceDTO dto = new ServiceDTO();
        dto.setId(entity.getId());
        dto.setBanner(entity.getBanner());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setDescription(entity.getDescription());
        dto.setReflection(entity.isReflection());

        return dto;
    }
    public static List<ServiceDTO> toDTOList(List<Service_> list){
        return list.stream().
                map(MapperService::toDTO)
                .collect(Collectors.toList());
    }
}
