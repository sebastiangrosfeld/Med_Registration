package com.example.med_registration_server.domain;

import jakarta.persistence.*;
import lombok.*;

@Value
@Embeddable
@AllArgsConstructor
@Builder
@NoArgsConstructor(force = true)
public class Service {

     String name;
     String description;

}
