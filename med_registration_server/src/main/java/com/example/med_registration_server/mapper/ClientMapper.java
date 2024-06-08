package com.example.med_registration_server.mapper;

import com.example.med_registration_server.domain.entity.Client;
import com.example.med_registration_server.dto.client.CreateClientRequest;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client clientFromCreateClientRequest(CreateClientRequest request) {
        return Client.builder()
                .email(request.email())
                .nick(request.nick())
                .name(request.name())
                .surname(request.surname())
                .phoneNumber(request.phoneNumber())
                .build();
    }
}
