package com.thedevhorse.cleanarchitecture.infra.controller.dto;

import com.thedevhorse.cleanarchitecture.domain.Category;

public record AthleteResponse(String athleteId, String name, Category category) {
}
