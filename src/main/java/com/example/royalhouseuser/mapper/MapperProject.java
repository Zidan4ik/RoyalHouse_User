package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.unifier.ProjectUnifier;
import com.example.royalhouseuser.model.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperProject {

    public static ProjectDTO toDTO(ProjectUnifier entity) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(entity.getProject().getId());
        dto.setIdBlock(Long.valueOf(Integer.valueOf(entity.getProject().getBlock())));
        dto.setName(entity.getProject().getName());
        dto.setAddress(entity.getProject().getAddress());
        dto.setRangeArea(findRangeArea(entity.getObjects()));
        dto.setRangePriceSquareMeter(findRangePrice(entity.getObjects()));

        return dto;
    }

    private static String findRangeArea(List<Object> objects) {

        if(!objects.isEmpty()){
            double maxArea = Double.MIN_VALUE;
            double minArea = Double.MAX_VALUE;
            for (Object o : objects) {
                if (o.getArea() > maxArea) maxArea = o.getArea();
                if (o.getArea() < minArea) minArea = o.getArea();
            }
            String average = minArea + "-" + maxArea + " м. кв.";
            return average;
        }
        return null;
    }

    private static String findRangePrice(List<Object> objects) {
        if(!objects.isEmpty()){
            double maxPrice = Double.MIN_VALUE;
            double minPrice = Double.MAX_VALUE;
            for (Object o : objects) {
                if (o.getArea() > maxPrice) maxPrice = o.getArea();
                if (o.getArea() < minPrice) minPrice = o.getArea();
            }
            String average = minPrice + "-" + maxPrice + " м. кв.";
            return average;
        }
        return null;
    }

    public static List<ProjectDTO> toDTOList(List<ProjectUnifier> unifiers) {
        return unifiers.stream()
                .map(MapperProject::toDTO)
                .collect(Collectors.toList());
    }
}
