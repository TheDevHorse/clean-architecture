package com.thedevhorse.cleanarchitecture.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<AthleteEntity, Integer> {
}
