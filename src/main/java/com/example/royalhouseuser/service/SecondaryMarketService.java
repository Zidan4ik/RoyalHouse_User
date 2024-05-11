package com.example.royalhouseuser.service;

import com.example.royalhouseuser.entity.SecondaryMarketBanner;

import java.util.List;
import java.util.Optional;

public interface SecondaryMarketService {
    Optional<SecondaryMarketBanner> getById(Long id);
    List<SecondaryMarketBanner> getAll();
}
