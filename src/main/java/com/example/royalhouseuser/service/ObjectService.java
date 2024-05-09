package com.example.royalhouseuser.service;


import com.example.royalhouseuser.entity.Object;

import java.util.List;
import java.util.Optional;

public interface ObjectService {
    List<Object> getAll();
    Optional<Object> getById(Long id);
}
