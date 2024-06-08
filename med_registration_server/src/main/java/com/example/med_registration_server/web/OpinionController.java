package com.example.med_registration_server.web;

import com.example.med_registration_server.domain.entity.Opinion;
import com.example.med_registration_server.dto.opinion.CreateOpinionRequest;
import com.example.med_registration_server.dto.opinion.DeleteOpinionRequest;
import com.example.med_registration_server.service.OpinionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/opinions")
@RequiredArgsConstructor
public class OpinionController {

    private final OpinionService opinionService;

    @PostMapping
    public ResponseEntity<Void> addOpinion(@RequestBody CreateOpinionRequest request) {
        opinionService.createOpinion(request);
        return new ResponseEntity<>(HttpStatusCode.valueOf(201));
    }

    @GetMapping("/byNick/{nick}")
    public ResponseEntity<List<Opinion>> getOpinionsByNick(@PathVariable String nick) {
        final var opinions = opinionService.getOpinionsByClientNick(nick);
        return ResponseEntity.ok(opinions);
    }

    @GetMapping("/byBusinessName/{name}")
    public ResponseEntity<List<Opinion>> getOpinionsByBusinessName(@PathVariable String name) {
        final var opinions = opinionService.getOpinionsByBusinessName(name);
        return ResponseEntity.ok(opinions);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByClient(@RequestBody DeleteOpinionRequest request) {
        opinionService.deleteOpinion(request);
        return ResponseEntity.noContent().build();
    }


}
