package com.example.med_registration_server.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String size;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Opinion> opinions;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Calendar calendar;

    @Embedded
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Localization location;

    @ElementCollection
    @EqualsAndHashCode.Exclude
    private List<Service> services;
}
