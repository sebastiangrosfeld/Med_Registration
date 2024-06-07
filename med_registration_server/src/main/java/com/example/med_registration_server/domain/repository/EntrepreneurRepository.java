package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepreneurRepository extends JpaRepository<Entrepreneur, Long> {
}
