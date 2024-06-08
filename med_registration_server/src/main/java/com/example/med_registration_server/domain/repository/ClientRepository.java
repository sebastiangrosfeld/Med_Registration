package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByEmailAndNick(String email, String nick);
    Optional<Client> findByNick(String nick);

    boolean existsByEmailAndNickAndPhoneNumber(String email, String nick, String phone);

    void deleteByEmailAndNickAndPhoneNumber(String email, String nick, String phone);
}
