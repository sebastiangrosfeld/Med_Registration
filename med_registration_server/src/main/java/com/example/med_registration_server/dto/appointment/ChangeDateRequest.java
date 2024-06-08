package com.example.med_registration_server.dto.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

public record ChangeDateRequest(
        String clientEmail,
        String clientNick,
        UUID calendarCode,
        LocalDateTime oldDateOfStart,
        LocalDateTime oldDateOfFinish,
        LocalDateTime newDateOfStart,
        LocalDateTime newDateOfFinish
) {
}
