package com.example.med_registration_server.service;

import com.example.med_registration_server.domain.repository.AppointmentRepository;
import com.example.med_registration_server.domain.repository.CalendarRepository;
import com.example.med_registration_server.domain.repository.ClientRepository;
import com.example.med_registration_server.dto.appointment.AppointmentPointRequest;
import com.example.med_registration_server.dto.appointment.AppointmentRequest;
import com.example.med_registration_server.dto.appointment.ChangeDateRequest;
import com.example.med_registration_server.mapper.AppointmentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final CalendarRepository calendarRepository;
    private final ClientRepository clientRepository;

    public void createAppointment(AppointmentRequest appointmentRequest) {
        final var appointment = appointmentMapper.mapAppointmentRequestToAppointment(appointmentRequest);
        if(appointmentRepository.existsByCalendarAndDateOfStartAndDateOfFinishAndClient(
            appointment.getCalendar(), appointment.getDateOfStart(), appointment.getDateOfFinish(), appointment.getClient()
        )) {
            appointmentRepository.save(appointment);
        } else {
            throw new RuntimeException("Unsupported operation");
        }
    }

    public void bookAppointment(AppointmentPointRequest appointmentPointRequest) {
        final var booking = appointmentMapper.mapAppointmentBookingToAppointment(appointmentPointRequest);
        if (appointmentRepository.existsByCalendarAndDateOfStartAndDateOfFinish(
                booking.getCalendar(),
                booking.getDateOfStart(),
                booking.getDateOfFinish()
        )) {
            throw new RuntimeException("Booking time already occupied.");
        }
        appointmentRepository.save(booking);
    }

    public void changeDateAppointment(ChangeDateRequest changeDateRequest) {
        final var calendar = calendarRepository.findCalendarByCalendarCode(changeDateRequest.calendarCode())
                .orElseThrow(() -> new RuntimeException("Calendar not found."));
        final var client = clientRepository.findByEmailAndNick(changeDateRequest.clientEmail(), changeDateRequest.clientNick())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        final var appointment = appointmentRepository.findByCalendarAndDateOfStartAndDateOfFinishAndClient(
                calendar,
                changeDateRequest.oldDateOfStart(),
                changeDateRequest.oldDateOfFinish(),
                client
        ).orElseThrow(() -> new RuntimeException("Requested appointment not exist."));
        if (appointmentRepository.existsByCalendarAndDateOfStartAndDateOfFinish(calendar, changeDateRequest.newDateOfStart(), changeDateRequest.newDateOfFinish()))
        {
            throw new RuntimeException("New date is occupied");
        }
        appointment.setDateOfStart(changeDateRequest.newDateOfStart());
        appointment.setDateOfFinish(changeDateRequest.newDateOfFinish());
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(AppointmentPointRequest deleted) {
        final var calendar = calendarRepository.findCalendarByCalendarCode(deleted.calendarCode())
                .orElseThrow(() -> new RuntimeException("Calendar not found."));
        final var client = clientRepository.findByEmailAndNick(deleted.clientEmail(), deleted.clientNick())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        final var appointment = appointmentRepository.findByCalendarAndDateOfStartAndDateOfFinishAndClient(
                calendar,
                deleted.dateOfStart(),
                deleted.dateOfFinish(),
                client
        ).orElseThrow(() -> new RuntimeException("Requested appointment not exist."));
        appointmentRepository.delete(appointment);
    }
}
