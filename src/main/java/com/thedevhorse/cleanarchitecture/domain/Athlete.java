package com.thedevhorse.cleanarchitecture.domain;

import java.util.Arrays;

public class Athlete {

    private Integer athleteId;

    private String name;

    private int age;

    private Category category;

    private Athlete(Integer athleteId,
                    String name,
                    int age) {
        this.athleteId = athleteId;
        this.name = name;
        this.age = age;
        setCategory(age);
    }

    public static Athlete create(final Integer athleteId,
                                 final String name,
                                 final int age) {
        return new Athlete(
                athleteId,
                name,
                age
        );
    }

    public Integer athleteId(){
        return athleteId;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    public Category category() {
        return category;
    }

    public Athlete changeCategory(int age) {
        setCategory(age);
        return this;
    }

    private void setCategory(int age) {
        this.category = Arrays.stream(Category.values())
                .filter(c -> age >= c.minAge() && age <= c.maxAge())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Category not found for the age: " + age));
    }
}
