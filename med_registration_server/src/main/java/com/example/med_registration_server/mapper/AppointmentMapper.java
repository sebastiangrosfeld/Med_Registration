package com.example.med_registration_server.mapper;

import com.example.med_registration_server.domain.entity.Appointment;
import com.example.med_registration_server.domain.repository.CalendarRepository;
import com.example.med_registration_server.domain.repository.ClientRepository;
import com.example.med_registration_server.dto.appointment.AppointmentPointRequest;
import com.example.med_registration_server.dto.appointment.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppointmentMapper {

    private final ClientRepository clientRepository;
    private final CalendarRepository calendarRepository;

    public Appointment mapAppointmentRequestToAppointment(AppointmentRequest appointmentRequest) {
        final var client = clientRepository
                .findByEmailAndNick(appointmentRequest.clientEmail(), appointmentRequest.clientNick())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        final var calendar = calendarRepository.findCalendarByCalendarCode(appointmentRequest.calendarCode())
                        .orElseThrow(() -> new RuntimeException("Calendar not found"));
        return Appointment.builder()
                .purpose(appointmentRequest.purpose())
                .client(client)
                .calendar(calendar)
                .isCompleted(false)
                .dateOfStart(appointmentRequest.dateOfStart())
                .dateOfFinish(appointmentRequest.dateOfFinish())
                .location(appointmentRequest.localization())
                .build();
    }

    public Appointment mapAppointmentBookingToAppointment(AppointmentPointRequest appointmentPointRequest) {
        final var client = clientRepository
                .findByEmailAndNick(appointmentPointRequest.clientEmail(), appointmentPointRequest.clientNick())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        final var calendar = calendarRepository.findCalendarByCalendarCode(appointmentPointRequest.calendarCode())
                .orElseThrow(() -> new RuntimeException("Calendar not found"));
        return Appointment.builder()
                .client(client)
                .calendar(calendar)
                .isCompleted(false)
                .dateOfStart(appointmentPointRequest.dateOfStart())
                .dateOfFinish(appointmentPointRequest.dateOfFinish())
                .build();
    }

}
