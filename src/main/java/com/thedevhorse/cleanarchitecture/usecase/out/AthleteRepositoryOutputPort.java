package com.thedevhorse.cleanarchitecture.usecase.out;

import com.thedevhorse.cleanarchitecture.domain.Athlete;

public interface AthleteRepositoryOutputPort {

   Athlete getAthleteById(Integer athleteId);

   void saveAthlete(Athlete athlete);
}
