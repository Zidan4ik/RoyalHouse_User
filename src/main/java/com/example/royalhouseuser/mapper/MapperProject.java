package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Object;
import com.example.royalhouseuser.entity.Project;
import com.example.royalhouseuser.model.ProjectDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperProject {

    public static ProjectDTO toDTO(Project entity) {
//        List<Object> objects = objectServiceImp.getAllByProject(entity);
        ProjectDTO dto = new ProjectDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
//        dto.setRangeArea(findRangeArea(objects));
//        dto.setRangePriceSquareMeter(findRangePrice(objects));

        return dto;
    }

    private static String findRangeArea(List<Object> objects) {
        double maxArea = 0;
        double minArea = 0;
        for (Object o : objects) {
            if (o.getArea() > maxArea) maxArea = o.getArea();
            if (o.getArea() < minArea) minArea = o.getArea();
        }
        String average = minArea + "-" + maxArea + " м. кв.";
        return average;
    }

    private static String findRangePrice(List<Object> objects) {
        double maxPrice = 0;
        double minPrice = 0;
        for (Object o : objects) {
            if (o.getArea() > maxPrice) maxPrice = o.getArea();
            if (o.getArea() < minPrice) minPrice = o.getArea();
        }
        String average = minPrice + "-" + maxPrice + " м. кв.";
        return average;
    }

    public static List<ProjectDTO> toDTOList(List<Project> projects) {
        return projects.stream()
                .map(MapperProject::toDTO)
                .collect(Collectors.toList());
    }
}
