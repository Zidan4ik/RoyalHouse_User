package com.example.royalhouseuser.service.serviceimp;

import com.example.royalhouseuser.entity.Contact;
import com.example.royalhouseuser.repo.ContactRepo;
import com.example.royalhouseuser.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImp implements ContactService {
    private final ContactRepo contactRepo;
    @Override
    public Optional<Contact> getById(Long id) {
        return contactRepo.findById(id);
    }
}
