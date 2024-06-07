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
public class Entrepreneur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String nip;

    @Column(nullable = false)
    private String name;

    @Column()
    private String description;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Settings settings;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Opinion> opinions;

    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Business> businesses;
}
