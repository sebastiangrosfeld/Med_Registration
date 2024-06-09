package com.example.med_registration_server.service;

import com.example.med_registration_server.domain.repository.EntrepreneurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntrepreneurService {

    private final EntrepreneurRepository entrepreneurRepository;
}
