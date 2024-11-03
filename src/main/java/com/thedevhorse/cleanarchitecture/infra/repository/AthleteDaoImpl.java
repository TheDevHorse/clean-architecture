package com.thedevhorse.cleanarchitecture.infra.repository;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteRepositoryOutputPort;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Repository;

@Repository
public class AthleteDaoImpl implements AthleteRepositoryOutputPort {

    private final AthleteRepository athleteRepository;

    public AthleteDaoImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Athlete getAthleteById(final String athleteId) {
       AthleteEntity athleteEntity  = athleteRepository.findByAthleteId(athleteId)
               .orElseThrow(() -> new NoResultException("Athlete not found."));

       return Athlete.create(
               athleteEntity.getAthleteId(),
               athleteEntity.getName(),
               athleteEntity.getAge()
       );
    }

    @Override
    public void saveAthlete(Athlete athlete) {
       // athleteRepository.save();
    }
}
