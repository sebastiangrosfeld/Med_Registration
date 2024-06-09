package com.example.med_registration_server.web;

import com.example.med_registration_server.service.SettingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/settings")
@RequiredArgsConstructor
public class SettingsController {

    private SettingsService settingsService;

    // Endpoints TO DO
}
