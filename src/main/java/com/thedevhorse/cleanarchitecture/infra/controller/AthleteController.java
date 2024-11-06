package com.thedevhorse.cleanarchitecture.infra.controller;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.infra.controller.dto.AthleteRequest;
import com.thedevhorse.cleanarchitecture.infra.controller.dto.AthleteResponse;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteInputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {

    private final AthleteInputPort athleteInputPort;

    public AthleteController(AthleteInputPort athleteInputPort) {
        this.athleteInputPort = athleteInputPort;
    }

    @GetMapping("/{athleteId}")
    public AthleteResponse getAthlete(@PathVariable String athleteId) {
        Athlete athlete = athleteInputPort.getAthlete(athleteId);

        return new AthleteResponse(
                athlete.athleteId(),
                athlete.name(),
                athlete.age(),
                athlete.category()
        );
    }

    @PostMapping
    public void createAthlete(AthleteRequest athleteRequest) {
        Athlete athlete = mapToAthlete(athleteRequest);
        athleteInputPort.createAthlete(athlete);
    }

    @PutMapping
    public void updateAthlete(AthleteRequest athleteRequest) {
        Athlete athlete = mapToAthlete(athleteRequest);
        athleteInputPort.updateAthlete(athlete);
    }

    private Athlete mapToAthlete(AthleteRequest athleteRequest) {
        return Athlete.create(
                athleteRequest.athleteId(),
                athleteRequest.name(),
                athleteRequest.age()
        );
    }
}
