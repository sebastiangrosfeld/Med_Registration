package com.example.med_registration_server.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nick;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Settings settings;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Opinion> opinions;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Appointment> appointments;


}
