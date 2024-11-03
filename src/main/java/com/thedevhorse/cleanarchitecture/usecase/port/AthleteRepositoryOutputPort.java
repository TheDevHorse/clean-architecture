package com.thedevhorse.cleanarchitecture.usecase.port;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteRepositoryOutputPort {

   Athlete getAthleteById(Integer athleteId);

   void saveAthlete(Athlete athlete);
}
