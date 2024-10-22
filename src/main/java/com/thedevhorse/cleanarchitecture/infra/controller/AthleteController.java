package com.thedevhorse.cleanarchitecture.infra.controller;

import com.thedevhorse.cleanarchitecture.usecase.in.AthleteInputPort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/citizen")
public class AthleteController {

    private final AthleteInputPort athleteInputPort;

    public AthleteController(AthleteInputPort athleteInputPort) {
        this.athleteInputPort = athleteInputPort;
    }


}
