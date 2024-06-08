package com.example.med_registration_server.dto.client;

public record DeleteClientRequest(
        String email,
        String nick,
        String phone
) {
}
