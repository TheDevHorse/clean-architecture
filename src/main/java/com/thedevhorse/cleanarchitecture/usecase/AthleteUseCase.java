package com.thedevhorse.cleanarchitecture.usecase;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.in.AthleteInputPort;
import org.springframework.stereotype.Service;

@Service
public class AthleteUseCase implements AthleteInputPort {

    @Override
    public Athlete getAthlete() {
        return null;
    }

    @Override
    public void createAthlete(final Athlete athlete) {

    }

    @Override
    public void updateAthlete(final Athlete athlete) {

    }
}
