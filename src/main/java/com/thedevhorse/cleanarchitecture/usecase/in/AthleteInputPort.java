package com.thedevhorse.cleanarchitecture.usecase.in;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteInputPort {

    Athlete getAthlete();

    void createAthlete(Athlete athlete);

    void updateAthlete(Athlete athlete);

}
