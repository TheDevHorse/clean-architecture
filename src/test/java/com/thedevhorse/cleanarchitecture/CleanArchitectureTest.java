package com.thedevhorse.cleanarchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class CleanArchitectureTest {

    @Test
    void givenCleanArchitectureClasses_thenLayerDependenciesAreRespected() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.thedevhorse.cleanarchitecture");

        Architectures.LayeredArchitecture architectureRules = layeredArchitecture()
                .consideringOnlyDependenciesInLayers()
                .layer("UseCase").definedBy("..usecase")
                .layer("InputPort").definedBy("..usecase.port.in")
                .layer("OutputPort").definedBy("..usecase.port.out")
                .layer("Infra").definedBy("..infra..")

                .whereLayer("UseCase").mayOnlyBeAccessedByLayers("InputPort")
                .whereLayer("UseCase").mayOnlyAccessLayers("OutputPort")
                .whereLayer("InputPort").mayOnlyBeAccessedByLayers("Infra")
                .whereLayer("OutputPort").mayOnlyBeAccessedByLayers("UseCase")

                .ignoreDependency(resideInAPackage("..infra.."), resideInAPackage("..usecase.port.out.."))
                .ignoreDependency(resideInAPackage("..usecase"), resideInAPackage("..usecase.port.in.."));

        architectureRules.check(importedClasses);
    }
}
