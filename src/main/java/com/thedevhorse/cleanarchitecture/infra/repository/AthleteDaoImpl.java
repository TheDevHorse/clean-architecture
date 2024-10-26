package com.thedevhorse.cleanarchitecture.infra.repository;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.out.AthleteRepositoryOutputPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AthleteDaoImpl implements AthleteRepositoryOutputPort {

    private final AthleteRepository athleteRepository;

    public AthleteDaoImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Athlete getAthleteById(Integer athleteId) {
       Optional<AthleteEntity> athleteEntity  =  athleteRepository.findById(athleteId);
       return null;
    }

    @Override
    public void saveAthlete(Athlete athlete) {
       // athleteRepository.save();
    }
}
