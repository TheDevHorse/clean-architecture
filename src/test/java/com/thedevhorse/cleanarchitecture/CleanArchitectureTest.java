package com.thedevhorse.cleanarchitecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

class CleanArchitectureTest {


    @Test
    void givenInfraClasses_thenShouldOnlyBeAccessedByUsecaseLayer() {
        JavaClasses jc = new ClassFileImporter().importPackages("com.thedevhorse.cleanarchitecture");

        Architectures.LayeredArchitecture arch = layeredArchitecture()
                // Define layers
                .layer("Infra").definedBy("..infra..")
                .layer("Usecase").definedBy("..usecase..")
                // Add constraints
                .whereLayer("Infra").mayOnlyBeAccessedByLayers("Usecase");

        arch.check(jc);
    }
}
