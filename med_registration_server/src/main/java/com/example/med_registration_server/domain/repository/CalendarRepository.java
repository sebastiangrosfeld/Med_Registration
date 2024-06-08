package com.example.med_registration_server.domain.repository;

import com.example.med_registration_server.domain.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    Optional<Calendar> findCalendarByCalendarCode(UUID calendarCode);
}
