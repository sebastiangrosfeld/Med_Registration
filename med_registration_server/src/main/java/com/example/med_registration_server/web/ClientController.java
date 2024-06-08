package com.example.med_registration_server.web;

import com.example.med_registration_server.dto.client.CreateClientRequest;
import com.example.med_registration_server.dto.client.DeleteClientRequest;
import com.example.med_registration_server.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Void> addClient (@RequestBody CreateClientRequest createClientRequest) {
        clientService.createClient(createClientRequest);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClient(@RequestBody DeleteClientRequest request) {
        clientService.deleteClient(request);
        return ResponseEntity.noContent().build();
    }
}
