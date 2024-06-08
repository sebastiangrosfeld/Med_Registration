package com.example.med_registration_server.service;

import com.example.med_registration_server.domain.entity.Opinion;
import com.example.med_registration_server.domain.repository.BusinessRepository;
import com.example.med_registration_server.domain.repository.ClientRepository;
import com.example.med_registration_server.domain.repository.OpinionRepository;
import com.example.med_registration_server.dto.opinion.CreateOpinionRequest;
import com.example.med_registration_server.dto.opinion.DeleteOpinionRequest;
import com.example.med_registration_server.mapper.OpinionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final ClientRepository clientRepository;
    private final BusinessRepository businessRepository;
    private final OpinionMapper opinionMapper;

    public void createOpinion(CreateOpinionRequest request) {
        final var opinion = opinionMapper.opinionFromCreateOpinionRequest(request);
        validateOpinion(opinion);
        opinionRepository.save(opinion);
    }

    public List<Opinion> getOpinionsByClientNick(String nick) {
        final var client = clientRepository.findByNick(nick)
                .orElseThrow(() -> new RuntimeException("Client with that nick not exist."));
        return opinionRepository.findAllByClient(client);
    }

    public List<Opinion> getOpinionsByBusinessName(String name) {
        final var business = businessRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Business with that name not exist."));
        return opinionRepository.findAllByBusiness(business);
    }

    public void deleteOpinion(DeleteOpinionRequest request) {
        final var business = businessRepository.findByName(request.businessName())
                .orElseThrow(() -> new RuntimeException("Business with that name not exist."));
        final var client = clientRepository.findByEmailAndNick(request.clientEmail(), request.clientNick())
                .orElseThrow(() -> new RuntimeException("Client with that nick not exist."));
        opinionRepository.deleteByBusinessAndClient(business, client);
    }

    private void validateOpinion(Opinion opinion) {
       final var code = opinion.getBusiness().getCalendar().getCalendarCode();
       final var calendarCodes = opinion.getClient().getAppointments()
               .stream().map(appointment -> appointment.getCalendar().getCalendarCode())
               .filter(calendarCode -> calendarCode == code)
               .toList();
       if (calendarCodes.isEmpty()) {
           throw new RuntimeException("Client cannot add opinion to this business.");
       }

    }
}
