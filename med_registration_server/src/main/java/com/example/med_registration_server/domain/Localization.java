package com.example.med_registration_server.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Embeddable
@AllArgsConstructor
@Builder
@NoArgsConstructor(force = true)
public class Localization {

    String town;
    String region;
    Float x;
    Float y;
}
