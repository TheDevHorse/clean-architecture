package com.thedevhorse.cleanarchitecture.infra.controller;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.infra.controller.dto.AthleteRequest;
import com.thedevhorse.cleanarchitecture.infra.controller.dto.AthleteResponse;
import com.thedevhorse.cleanarchitecture.usecase.port.in.AthleteInputPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/athletes")
public class AthleteController {

    private final AthleteInputPort athleteInputPort;

    public AthleteController(AthleteInputPort athleteInputPort) {
        this.athleteInputPort = athleteInputPort;
    }

    @GetMapping("/{athleteId}")
    public AthleteResponse getAthlete(@PathVariable String athleteId) {
        return mapToAthleteResponse(
                athleteInputPort.getAthlete(athleteId)
        );
    }

    @PostMapping
    public void createAthlete(@RequestBody AthleteRequest athleteRequest) {
        athleteInputPort.createAthlete(
                mapToAthlete(athleteRequest)
        );
    }

    @PutMapping
    public void updateAthlete(@RequestBody  AthleteRequest athleteRequest) {
        athleteInputPort.updateAthlete(
                mapToAthlete(athleteRequest)
        );
    }

    private AthleteResponse mapToAthleteResponse(Athlete athlete) {
        return new AthleteResponse(
                athlete.athleteId(),
                athlete.name(),
                athlete.age(),
                athlete.category()
        );
    }

    private Athlete mapToAthlete(AthleteRequest athleteRequest) {
        return Athlete.create(
                athleteRequest.athleteId(),
                athleteRequest.name(),
                athleteRequest.age()
        );
    }
}
