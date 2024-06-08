package com.example.med_registration_server.dto.opinion;

public record DeleteOpinionRequest(
        String clientEmail,
        String clientNick,
        String businessName
) {
}
