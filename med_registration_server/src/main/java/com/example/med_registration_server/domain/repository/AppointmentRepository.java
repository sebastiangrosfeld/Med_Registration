package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.entity.Appointment;
import com.example.med_registration_server.domain.entity.Calendar;
import com.example.med_registration_server.domain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    boolean existsByCalendarAndDateOfStartAndDateOfFinish(Calendar calendar, LocalDateTime dateOfStart, LocalDateTime dateOfFinish );

    boolean existsByCalendarAndDateOfStartAndDateOfFinishAndClient(Calendar calendar, LocalDateTime dateOfStart, LocalDateTime dateOfFinish, Client client);
    Optional<Appointment> findByCalendarAndDateOfStartAndDateOfFinishAndClient(Calendar calendar, LocalDateTime dateOfStart, LocalDateTime dateOfFinish, Client client);

}
