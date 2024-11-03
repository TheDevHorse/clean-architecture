package com.thedevhorse.cleanarchitecture.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AthleteRepository extends JpaRepository<AthleteEntity, Integer> {

    Optional<AthleteEntity> findByAthleteId(String athleteId);
}
