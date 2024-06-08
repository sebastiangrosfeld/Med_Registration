package com.example.med_registration_server.dto.appointment;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentPointRequest(
        UUID calendarCode,
        LocalDateTime dateOfStart,
        LocalDateTime dateOfFinish,
        String clientEmail,
        String clientNick
) {
}
