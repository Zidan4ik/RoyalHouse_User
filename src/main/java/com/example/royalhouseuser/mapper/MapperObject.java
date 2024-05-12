package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.entity.unifier.ObjectUnifier;
import com.example.royalhouseuser.enums.Building;
import com.example.royalhouseuser.model.ObjectDTO;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperObject {
    public static ObjectDTO toDTO(ObjectUnifier unifier) {
        ObjectDTO dto = new ObjectDTO();
        dto.setId(unifier.getObject().getId());
        dto.setName(unifier.getProject().getName());
        dto.setAddress(unifier.getProject().getAddress());
        dto.setRooms(String.valueOf(unifier.getObject().getRooms()));
        dto.setStorey(String.valueOf(unifier.getObject().getStorey()));
        dto.setArea(String.valueOf(unifier.getObject().getArea()));
        dto.setPriceSquareMeter(String.valueOf(Math.round(unifier.getObject().getPrice() / unifier.getObject().getArea())));
        dto.setTotalPrice(String.valueOf(unifier.getObject().getPrice()));

        dto.setImage1(unifier.getObject().getImageFirst());
        dto.setImage2(unifier.getObject().getImageSecond());
        dto.setImage3(unifier.getObject().getImageThird());

        if(unifier.getObject().getBuilding().equals(Building.house)){
            dto.setType("Будинок");
        }
        if(unifier.getObject().getBuilding().equals(Building.apartment)){
            dto.setType("Квартира");
        }
        if(unifier.getObject().getBuilding().equals(Building.commercial)){
            dto.setType("Комерційний");
        }
        if(unifier.getObject().getBuilding().equals(Building.plot)){
            dto.setType("Земельна ділянка");
        }

        return dto;
    }
    public static List<ObjectDTO> toDTOList(List<ObjectUnifier> list){
        return list.stream()
                .map(MapperObject::toDTO)
                .collect(Collectors.toList());
    }
}
