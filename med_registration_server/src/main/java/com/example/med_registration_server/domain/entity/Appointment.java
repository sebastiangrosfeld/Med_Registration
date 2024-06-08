package com.example.med_registration_server.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column
    private String purpose;

    @Column(nullable = false)
    private LocalDateTime dateOfStart;

    @Column(nullable = false)
    private LocalDateTime dateOfFinish;

    @Column(nullable = false)
    private Boolean isCompleted;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Client client;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Calendar calendar;

    @Embedded
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Localization location;
}
