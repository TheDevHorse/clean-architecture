package com.thedevhorse.cleanarchitecture.usecase.port.in;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteInputPort {

    Athlete getAthlete(String athleteId);

    void createAthlete(Athlete athlete);

    void updateAthlete(Athlete athlete);

}
