package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.Contact;

import java.util.Optional;

public interface ContactService {
    Optional<Contact> getById(Long id);
}
