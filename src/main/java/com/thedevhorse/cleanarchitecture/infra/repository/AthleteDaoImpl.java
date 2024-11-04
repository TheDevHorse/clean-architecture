package com.thedevhorse.cleanarchitecture.infra.repository;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.port.AthleteRepositoryOutputPort;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Component;

@Component
public class AthleteDaoImpl implements AthleteRepositoryOutputPort {

    private final AthleteRepository athleteRepository;

    public AthleteDaoImpl(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    @Override
    public Athlete getAthleteById(final String athleteId) {
        AthleteEntity athleteEntity = findEntityById(athleteId);
        return mapToAthlete(athleteEntity);
    }

    @Override
    public void createAthlete(Athlete athlete) {
        AthleteEntity athleteEntity = mapToAthleteEntity(athlete);
        athleteRepository.save(athleteEntity);
    }

    @Override
    public void updateAthlete(Athlete athlete) {
        AthleteEntity athleteEntity = findEntityById(athlete.athleteId());
        athleteEntity.setAge(athlete.age());

        athleteRepository.save(athleteEntity);
    }

    private AthleteEntity findEntityById(String athleteId) {
        return athleteRepository.findByAthleteId(athleteId)
                .orElseThrow(() -> new NoResultException("Athlete not found."));
    }

    private Athlete mapToAthlete(AthleteEntity athleteEntity) {
        return Athlete.create(
                athleteEntity.getAthleteId(),
                athleteEntity.getName(),
                athleteEntity.getAge()
        );
    }

    private AthleteEntity mapToAthleteEntity(Athlete athlete) {
        AthleteEntity athleteEntity = new AthleteEntity();
        athleteEntity.setAthleteId(athlete.athleteId());
        athleteEntity.setName(athlete.name());
        athleteEntity.setAge(athlete.age());
        return athleteEntity;
    }
}
