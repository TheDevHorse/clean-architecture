package com.thedevhorse.cleanarchitecture.infra.controller.dto;

import com.thedevhorse.cleanarchitecture.domain.Category;

public record AthleteResponse(Integer athleteId, String name, Category category) {
}
