package com.thedevhorse.cleanarchitecture.infra.repository;

import com.thedevhorse.cleanarchitecture.domain.Athlete;
import com.thedevhorse.cleanarchitecture.usecase.out.AthleteRepositoryOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class AthleteRepositoryDaoImpl implements AthleteRepositoryOutputPort {
    @Override
    public Athlete getAthleteById(Integer athleteId) {
        return null;
    }
}
