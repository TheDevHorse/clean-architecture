package com.thedevhorse.cleanarchitecture.usecase;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.port.in.AthleteInputPort;
import com.thedevhorse.cleanarchitecture.usecase.port.out.AthleteDaoOutputPort;
import org.springframework.stereotype.Service;

@Service
public class AthleteUseCaseImpl implements AthleteInputPort {

    private final AthleteDaoOutputPort athleteDaoOutputPort;

    public AthleteUseCaseImpl(AthleteDaoOutputPort athleteDaoOutputPort) {
        this.athleteDaoOutputPort = athleteDaoOutputPort;
    }

    @Override
    public Athlete getAthlete(String athleteId) {
        return athleteDaoOutputPort.getAthleteById(athleteId);
    }

    @Override
    public void createAthlete(final Athlete athlete) {
        athleteDaoOutputPort.createAthlete(athlete);
    }

    @Override
    public void updateAthlete(final Athlete athlete) {
        athleteDaoOutputPort.updateAthlete(athlete);
    }
}
