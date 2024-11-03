package com.thedevhorse.cleanarchitecture.usecase;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteInputPort;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteRepositoryOutputPort;
import org.springframework.stereotype.Service;

@Service
public class AthleteUseCaseImpl implements AthleteInputPort {

    private final AthleteRepositoryOutputPort athleteRepositoryOutputPort;

    public AthleteUseCaseImpl(AthleteRepositoryOutputPort athleteRepositoryOutputPort) {
        this.athleteRepositoryOutputPort = athleteRepositoryOutputPort;
    }

    @Override
    public Athlete getAthlete(Integer athleteId) {
        return athleteRepositoryOutputPort.getAthleteById(athleteId);
    }

    @Override
    public void createAthlete(final Athlete athlete) {
        athleteRepositoryOutputPort.saveAthlete(athlete);
    }

    @Override
    public void updateAthlete(final Athlete athlete) {
        athleteRepositoryOutputPort.saveAthlete(athlete);
    }
}
