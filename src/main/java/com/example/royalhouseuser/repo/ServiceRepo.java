package com.example.royalhouseuser.repo;

import com.example.royalhouseuser.entity.Service_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepo extends JpaRepository<Service_,Long> {
}
