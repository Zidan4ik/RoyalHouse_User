package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.SecondaryMarketBanner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondaryMarketRepo extends JpaRepository<SecondaryMarketBanner,Long> {
}
