package com.thedevhorse.cleanarchitecture.usecase.port;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteRepositoryOutputPort {

   Athlete getAthleteById(String athleteId);

   void saveAthlete(Athlete athlete);
}
