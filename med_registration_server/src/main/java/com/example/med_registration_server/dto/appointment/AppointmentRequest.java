package com.example.med_registration_server.dto.appointment;

import com.example.med_registration_server.domain.entity.Localization;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record AppointmentRequest(
        String purpose,
        LocalDateTime dateOfStart,
        LocalDateTime dateOfFinish,
        String clientEmail,
        String clientNick,
        Localization localization,
        UUID calendarCode
) {
}
