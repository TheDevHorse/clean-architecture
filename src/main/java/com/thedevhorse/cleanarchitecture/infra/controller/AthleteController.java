package com.thedevhorse.cleanarchitecture.infra.controller;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.infra.controller.dto.AthleteResponse;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteInputPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/athlete")
public class AthleteController {

    private final AthleteInputPort athleteInputPort;

    public AthleteController(AthleteInputPort athleteInputPort) {
        this.athleteInputPort = athleteInputPort;
    }

    @GetMapping("/{athleteId}")
    public AthleteResponse getAthlete(@PathVariable Integer athleteId) {
        Athlete athlete = athleteInputPort.getAthlete(athleteId);

        return new AthleteResponse(
                athlete.athleteId(),
                athlete.name(),
                athlete.category()
        );
    }
}
