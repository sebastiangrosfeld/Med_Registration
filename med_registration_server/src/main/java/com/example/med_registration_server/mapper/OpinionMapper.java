package com.example.med_registration_server.mapper;

import com.example.med_registration_server.domain.entity.Opinion;
import com.example.med_registration_server.domain.repository.BusinessRepository;
import com.example.med_registration_server.domain.repository.ClientRepository;
import com.example.med_registration_server.dto.opinion.CreateOpinionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class OpinionMapper {

    private final ClientRepository clientRepository;
    private final BusinessRepository businessRepository;

    public Opinion opinionFromCreateOpinionRequest(CreateOpinionRequest request) {
        final var client = clientRepository.findByEmailAndNick(request.clientEmail(), request.clientNick())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        final var business = businessRepository.findByName(request.businessName())
                .orElseThrow(() -> new RuntimeException("Business not found"));
        return Opinion.builder()
                .client(client)
                .business(business)
                .description(request.description())
                .stars(request.rate())
                .title(request.title())
                .publishDate(LocalDate.now())
                .build();
    }
}
