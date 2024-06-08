package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.entity.Business;
import com.example.med_registration_server.domain.entity.Client;
import com.example.med_registration_server.domain.entity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Integer> {

    List<Opinion> findAllByClient(Client client);

    List<Opinion> findAllByBusiness(Business business);

    void deleteByBusinessAndClient(Business business, Client client);
}
