package com.example.med_registration_server.web;

import com.example.med_registration_server.domain.entity.Appointment;
import com.example.med_registration_server.dto.appointment.AppointmentPointRequest;
import com.example.med_registration_server.dto.appointment.AppointmentRequest;
import com.example.med_registration_server.dto.appointment.ChangeDateRequest;
import com.example.med_registration_server.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping("/create")
    public ResponseEntity<Void> addAppointment(@RequestBody AppointmentRequest appointment) {
        appointmentService.createAppointment(appointment);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @PostMapping("/book")
    public ResponseEntity<Void> bookAppointment(@RequestBody AppointmentPointRequest booking) {
        appointmentService.bookAppointment(booking);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @PatchMapping("/edit-date")
    public ResponseEntity<Void> editDate(@RequestBody ChangeDateRequest changeDateRequest) {
        appointmentService.changeDateAppointment(changeDateRequest);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAppointment(@RequestBody AppointmentPointRequest deleted) {
        appointmentService.deleteAppointment(deleted);
        return ResponseEntity.noContent().build();
    }
}
