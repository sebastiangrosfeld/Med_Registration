package com.example.med_registration_server.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID calendarCode;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Appointment> appointments;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Business business;
}
