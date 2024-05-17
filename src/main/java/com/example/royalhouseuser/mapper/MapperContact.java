package com.example.royalhouseuser.mapper;

import com.example.royalhouseuser.entity.Contact;
import com.example.royalhouseuser.model.ContactDTO;
import org.springframework.stereotype.Service;

@Service
public class MapperContact {
    public static ContactDTO toDTO(Contact entity){
        ContactDTO dto = new ContactDTO();
        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setViber(entity.getViber());
        dto.setEmail(entity.getEmail());
        dto.setInstagram(entity.getInstagram());
        dto.setFacebook(entity.getFacebook());
        dto.setTelegram(entity.getTelegram());
        dto.setAddress(entity.getAddress());
        dto.setLength(String.valueOf(entity.getLength()));
        dto.setWidth(String.valueOf(entity.getWidth()));
        return dto;
    }
}
