package com.thedevhorse.cleanarchitecture.infra.repository;

import com.thedevhorse.cleanarchitecture.domain.Category;
import jakarta.persistence.*;

@Entity
@Table(name="Athlete")
public class AthleteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String athleteId;
    private int age;
    @Enumerated(EnumType.STRING)
    private Category category;

    public AthleteEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getAthleteId() {
        return athleteId;
    }

    public int getAge() {
        return age;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAthleteId(String athleteId) {
        this.athleteId = athleteId;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
