package com.example.med_registration_server.dto.opinion;

import java.time.LocalDate;

public record CreateOpinionRequest(
        String title,
        Integer rate,
        String description,
        String clientEmail,
        String clientNick,
        String businessName
) {
}
