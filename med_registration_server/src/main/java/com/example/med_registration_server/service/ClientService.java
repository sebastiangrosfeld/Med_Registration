package com.example.med_registration_server.service;

import com.example.med_registration_server.domain.repository.ClientRepository;
import com.example.med_registration_server.dto.client.CreateClientRequest;
import com.example.med_registration_server.dto.client.DeleteClientRequest;
import com.example.med_registration_server.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    public void createClient(CreateClientRequest createClientRequest) {
        if(clientRepository.existsByEmailAndNickAndPhoneNumber(
                createClientRequest.email(),
                createClientRequest.nick(),
                createClientRequest.phoneNumber()
        )) {
            throw new RuntimeException("Client already exist");
        }
        final var client = clientMapper.clientFromCreateClientRequest(createClientRequest);
        clientRepository.save(client);
    }

    public void deleteClient(DeleteClientRequest deleteClientRequest) {
        if(!clientRepository.existsByEmailAndNickAndPhoneNumber(
                deleteClientRequest.email(),
                deleteClientRequest.nick(),
                deleteClientRequest.phone()
        )) {
            throw new RuntimeException("Client already exist");
        }
        clientRepository.deleteByEmailAndNickAndPhoneNumber(
                deleteClientRequest.email(), deleteClientRequest.nick(), deleteClientRequest.phone()
        );
    }
}
