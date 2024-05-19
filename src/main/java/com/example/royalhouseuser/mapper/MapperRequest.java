package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Request;
import com.example.royalhouseuser.model.RequestDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MapperRequest {
    public static Request toEntity(RequestDTO dto){
        Request entity = new Request();
        entity.setId(dto.getId());
        entity.setFullName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setDate(LocalDateTime.now());
        entity.setComment(dto.getComment());

        return entity;
    }
}
