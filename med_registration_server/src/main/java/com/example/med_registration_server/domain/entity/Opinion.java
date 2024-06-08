package com.example.med_registration_server.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Opinion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer stars;

    @Column(nullable = false)
    private LocalDate publishDate;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Client client;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Business business;

}
