package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {
}
