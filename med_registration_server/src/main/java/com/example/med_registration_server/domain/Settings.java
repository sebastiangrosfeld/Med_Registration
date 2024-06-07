package com.example.med_registration_server.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Long id;

    @Column(nullable = false)
    private Boolean option1;

    @Column(nullable = false)
    private Boolean option2;
}
