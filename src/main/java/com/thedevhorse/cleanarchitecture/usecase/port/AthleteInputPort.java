package com.thedevhorse.cleanarchitecture.usecase.port;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteInputPort {

    Athlete getAthlete(Integer athleteId);

    void createAthlete(Athlete athlete);

    void updateAthlete(Athlete athlete);

}
