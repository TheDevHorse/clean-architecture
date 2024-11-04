package com.thedevhorse.cleanarchitecture.usecase.port;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteRepositoryOutputPort {

   Athlete getAthleteById(String athleteId);

   void createAthlete(Athlete athlete);

   void updateAthlete(Athlete athlete);
}
