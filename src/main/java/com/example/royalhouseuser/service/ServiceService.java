package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.Service_;

import java.util.List;
import java.util.Optional;

public interface ServiceService {
    Optional<Service_> getById(Long id);
    List<Service_> getAll();
}
