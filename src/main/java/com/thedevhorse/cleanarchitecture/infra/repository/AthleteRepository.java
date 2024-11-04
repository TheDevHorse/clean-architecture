package com.thedevhorse.cleanarchitecture.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AthleteRepository extends JpaRepository<AthleteEntity, Integer> {

    Optional<AthleteEntity> findByAthleteId(String athleteId);
}
