package com.example.med_registration_server.dto.client;

public record CreateClientRequest(
        String email,
        String nick,
        String name,
        String surname,
        String phoneNumber
) {
}
